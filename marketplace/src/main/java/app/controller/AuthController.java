package app.controller;


import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import app.common.exception.CustomException;
import app.dto.RegisterRequest;
import app.service.AuthService;
import lombok.RequiredArgsConstructor;

@RestController
@RequestMapping("auth")
@RequiredArgsConstructor
public class AuthController {
	 private final AuthService service ;
//	 private final ResponseService responseService ;

	 @PostMapping("/register")
	  public ResponseEntity<?> register(
	      @RequestBody RegisterRequest request
	  ) {
		  try {
			  return ResponseEntity.ok(service.register(request));			  
		  }catch(CustomException ex) {
			  return ResponseEntity.status(ex.getHttpStatus().value())
	                    .body(ex.getMessage());		  }
	  }
	 
	 @PostMapping("/login")
	  public ResponseEntity<?> signin(
	      @RequestBody RegisterRequest request
	  ) {
		  try {
			  return ResponseEntity.ok(service.authenticate(request));			  
		  }catch(CustomException ex) {
			  return ResponseEntity.status(ex.getHttpStatus().value())
	                    .body(ex.getMessage());		  }
	  }
//	  @PostMapping("/authenticate")
//	  public ResponseEntity<AuthenticationResponse> authenticate(
//	      @RequestBody AuthenticationRequest request
//	  ) {
//	    return ResponseEntity.ok(service.authenticate(request));
//	  }

}
