package app.controller;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.config.annotation.method.configuration.EnableMethodSecurity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import app.dto.PaginatedResponse;
import app.model.Product;
import app.service.ProductService;

@RestController
@EnableMethodSecurity()
@RequestMapping("products")
public class ProductController {

	private ProductService productService;

	public ProductController(ProductService productService) {
		this.productService = productService;
	}

	@GetMapping()
	public ResponseEntity<PaginatedResponse<Product>> getProducts(Pageable pageable) {
		return this.productService.findAll(pageable);
	}
	
	@PreAuthorize("hasAuthority('ROLE_USER')")
	  @GetMapping("/hello")
	  public ResponseEntity<String> sayHello() {
	    return ResponseEntity.ok("Hello from secured endpoint");
	  }

}
