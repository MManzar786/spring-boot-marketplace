package app.service;

import java.util.List;

import app.dto.ProductDto;

public interface ProductService {
	ProductDto findById(Long id);

    List<ProductDto> findAll();

    ProductDto save(ProductDto productDto);


}
