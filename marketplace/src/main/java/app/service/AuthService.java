package app.service;

import app.dto.AuthenticationRequest;
import app.dto.AuthenticationResponse;
import app.dto.RegisterRequest;
import app.dto.RegisterResponse;

public interface AuthService {

	RegisterResponse register(RegisterRequest request);

	AuthenticationResponse authenticate(AuthenticationRequest request);

}
