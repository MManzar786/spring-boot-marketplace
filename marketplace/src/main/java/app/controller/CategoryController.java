package app.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.security.config.annotation.method.configuration.EnableMethodSecurity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import app.common.exception.CustomException;
import app.service.CategoryService;
import lombok.RequiredArgsConstructor;

@RestController
@RequestMapping("category")
@RequiredArgsConstructor
@EnableMethodSecurity()
public class CategoryController {

	private final CategoryService categoryService ;
	 @GetMapping()
	  public ResponseEntity<?> getAll() {
		  try {
			  return ResponseEntity.ok(categoryService.findAll());			  
		  }catch(CustomException ex) {
			  return ResponseEntity.status(ex.getHttpStatus().value())
	                    .body(ex.getMessage());		  }
	  }
}
