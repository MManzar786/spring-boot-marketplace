package app.service.impl;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import app.dto.PaginatedResponse;
import app.model.Product;
import app.repository.ProductRepository;
import app.service.ProductService;

@Service
public class ProductServiceImpl implements ProductService{

	private ProductRepository productRepository;
	
    public ProductServiceImpl(
            ProductRepository productsRepository) {
        this.productRepository = productsRepository;
    }
	

	@Override
	public ResponseEntity<PaginatedResponse<Product>> findAll(Pageable pageable) {
		Page<Product> products = productRepository.findAll(pageable);
	    long totalProducts = products.getTotalElements();
	    return ResponseEntity.ok(PaginatedResponse.of(products.getContent(), totalProducts, pageable));
	}

}
