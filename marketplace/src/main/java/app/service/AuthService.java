package app.service;

import org.springframework.http.HttpStatus;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import app.common.exception.CustomException;
import app.config.JwtService;
import app.dto.AuthenticationResponse;
import app.dto.RegisterRequest;
import app.dto.RegisterResponse;
import app.enums.ERole;
import app.model.User;
import app.repository.TokenRepository;
import app.repository.UserRepository;
import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class AuthService {
	private JwtService jwtService = new JwtService();
	private final UserRepository userRepository;
	private final TokenRepository tokenRepository;
	private final PasswordEncoder passwordEncoder;
	private final AuthenticationManager authenticationManager;

	public RegisterResponse register(RegisterRequest appUser) {
		if (!userRepository.existsByEmail(appUser.getEmail())) {
			var user = new User();
			user.setEmail(appUser.getEmail());
			user.setFirstName(appUser.getFirstname());
			user.setLastName(appUser.getLastname());
			user.setPassword(passwordEncoder.encode(appUser.getPassword()));
			user.setRole(ERole.ROLE_USER);
			String jwtToken = jwtService.generateToken(user);
			User savedUser = userRepository.save(user);

			return RegisterResponse.builder().token(jwtToken).user(savedUser).build();
		} else {
			throw new CustomException("Username is already in use", HttpStatus.UNPROCESSABLE_ENTITY);
		}
}

	public AuthenticationResponse authenticate(RegisterRequest request) {
		try {
			authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(request.getEmail(), request.getPassword()));
			 var user = userRepository.findByEmail(request.getEmail())
				        .orElseThrow();
			String jwtToken = jwtService.generateToken(user);
			return AuthenticationResponse.builder()
			        .token(jwtToken)
			        .email(user.getEmail())
			        .firstname(user.getFirstName())
			        .lastname(user.getLastName())
			        .build(); 
		} catch (AuthenticationException e) {
			throw new CustomException("Invalid username/password supplied", HttpStatus.UNPROCESSABLE_ENTITY);
		}
	}
}
