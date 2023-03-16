package app.controller;


import org.springframework.http.ResponseEntity;
import org.springframework.security.config.annotation.method.configuration.EnableMethodSecurity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import app.common.exception.CustomException;
import app.dto.AuthenticationRequest;
import app.dto.RegisterRequest;
import app.service.AuthService;

@RestController
@EnableMethodSecurity()
@RequestMapping("auth")
public class AuthController {
	 private final AuthService authService ;
	 
	 public AuthController(AuthService authService) {
			this.authService = authService;
		}

	 @PostMapping("/register")
	  public ResponseEntity<?> register(
	      @RequestBody RegisterRequest request
	  ) {
		  try {
			  return ResponseEntity.ok(this.authService.register(request));			  
		  }catch(CustomException ex) {
			  return ResponseEntity.status(ex.getHttpStatus().value())
	                    .body(ex.getMessage());		  }
	  }
	 
	 @PostMapping("/login")
	  public ResponseEntity<?> signin(
	      @RequestBody AuthenticationRequest request
	  ) {
		  try {
			  return ResponseEntity.ok(this.authService.authenticate(request));			  
		  }catch(CustomException ex) {
			  return ResponseEntity.status(ex.getHttpStatus().value())
	                    .body(ex.getMessage());		  }
	  }

}
