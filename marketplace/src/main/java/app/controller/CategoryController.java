package app.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import app.common.exception.CustomException;
import app.dto.AuthenticationRequest;
import app.service.AuthService;
import lombok.RequiredArgsConstructor;
//
//@RestController
//@RequestMapping("category")
//@RequiredArgsConstructor
public class CategoryController {

//	private final CategoryService service ;
//	
//	 @GetMapping()
//	  public ResponseEntity<?> getAll(
//	  ) {
//		  try {
//			  return ResponseEntity.ok(service.authenticate(request));			  
//		  }catch(CustomException ex) {
//			  return ResponseEntity.status(ex.getHttpStatus().value())
//	                    .body(ex.getMessage());		  }
//	  }
}
