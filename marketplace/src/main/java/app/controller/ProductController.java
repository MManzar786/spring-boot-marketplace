package app.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import app.dto.ProductDto;
import app.service.ProductService;

@RestController
@RequestMapping("products")
public class ProductController {

	private ProductService productService;

	public ProductController(ProductService productService) {
		this.productService = productService;
	}

	@GetMapping("{id}")
	public ProductDto findById(@PathVariable Long id) {
		return this.productService.findById(id);
	}

	@GetMapping()
	public List<ProductDto> findAll() {
		return this.productService.findAll();
	}

	@PostMapping
	public ProductDto save(@RequestBody ProductDto productDto) {
		productDto.setId(null);
		return this.productService.save(productDto);
	}

}
