package app.service;

import java.math.BigDecimal;

import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.web.multipart.MultipartFile;

import app.dto.PaginatedResponse;
import app.model.Product;

public interface ProductService {
	ResponseEntity<PaginatedResponse<Product>> findAll(Pageable pageable);
	ResponseEntity<PaginatedResponse<Product>> findAll(String title,Pageable pageable);
	ResponseEntity<Product> addProduct(String title, String description, String category, double price,
			MultipartFile image,String uploadDir);
}
