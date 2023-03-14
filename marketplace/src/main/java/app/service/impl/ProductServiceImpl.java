package app.service.impl;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import app.dto.ProductDto;
import app.exception.ResourceNotFoundException;
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
	public ProductDto findById(Long id) {
	    Product product = this.productRepository
                .findById(id)
                .orElseThrow(() -> new ResourceNotFoundException(id));

        return new ProductDto(product);
	}

	@Override
	public List<ProductDto> findAll() {
		List<ProductDto> list= this.productRepository
        .findAll()
        .stream()
        .map(product -> new ProductDto(product))
        .collect(Collectors.toList());
		return list;
	}

	@Override
	public ProductDto save(ProductDto productDto) {
		// TODO Auto-generated method stub
		return null;
	}

}
