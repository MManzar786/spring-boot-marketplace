package app.controller;

import java.io.File;

import org.springframework.data.domain.Pageable;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.config.annotation.method.configuration.EnableMethodSecurity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import app.common.utils.Constants;
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
	public ResponseEntity<PaginatedResponse<Product>> getProducts(
			@RequestParam(name = "title", required = false) String title, Pageable pageable) {
		if (title != null) {
			return this.productService.findAll(title, pageable);
		} else {
			return this.productService.findAll(pageable);
		}

	}
	
	@GetMapping("category")
	public ResponseEntity<PaginatedResponse<Product>> getProductsByCategory(
			@RequestParam(name = "category", required = false) Long category, Pageable pageable) {
			return this.productService.findProductsByCategory(category, pageable);

	}

	@PreAuthorize("hasAuthority('ROLE_ADMIN')")
	@PostMapping(path = "/add", consumes = MediaType.MULTIPART_FORM_DATA_VALUE)
	public ResponseEntity<?> addProduct(@RequestParam("title") String title,
			@RequestParam("description") String description, @RequestParam("category") String category,
			@RequestParam("price") double price, @RequestParam("image") MultipartFile image) {
		String uploadDir = new File("uploads").getAbsolutePath();

		try {
			return this.productService.addProduct(title, description, category, price, image, uploadDir);
		} catch (Exception ex) {
			ex.printStackTrace();
			return ResponseEntity.status(Constants.INTERNAL_SERVER_ERROR).body(ex.getMessage());
		}
	}

}
