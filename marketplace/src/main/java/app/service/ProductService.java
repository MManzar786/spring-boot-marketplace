package app.service;

import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;

import app.dto.PaginatedResponse;
import app.model.Product;

public interface ProductService {
	ResponseEntity<PaginatedResponse<Product>> findAll(Pageable pageable);
}
