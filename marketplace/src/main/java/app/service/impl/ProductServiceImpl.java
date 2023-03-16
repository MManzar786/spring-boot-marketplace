package app.service.impl;

import java.io.IOException;
import java.io.InputStream;
import java.math.BigDecimal;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import app.dto.PaginatedResponse;
import app.model.Category;
import app.model.Product;
import app.repository.CategoryRepository;
import app.repository.ProductRepository;
import app.service.ProductService;

@Service
public class ProductServiceImpl implements ProductService{

	private ProductRepository productRepository;
	private CategoryRepository categoryRepository;
	
    public ProductServiceImpl(
            ProductRepository productsRepository,CategoryRepository categoryRepository) {
        this.productRepository = productsRepository;
        this.categoryRepository = categoryRepository;
    }

	@Override
	public ResponseEntity<PaginatedResponse<Product>> findAll(Pageable pageable) {
		Page<Product> products = productRepository.findAll(pageable);
	    long totalProducts = products.getTotalElements();
	    return ResponseEntity.ok(PaginatedResponse.of(products.getContent(), totalProducts, pageable));
	}
	
	@Override
	public ResponseEntity<PaginatedResponse<Product>> findAll(String title,Pageable pageable) {
		Page<Product> products = productRepository.findByTitle(title,pageable);
	    long totalProducts = products.getTotalElements();
	    return ResponseEntity.ok(PaginatedResponse.of(products.getContent(), totalProducts, pageable));
	}

	@Override
	public ResponseEntity<Product> addProduct(String title, String description, String categoryTitle, double price,
			MultipartFile image,String uploadDir) {
		 String filename = StringUtils.cleanPath(image.getOriginalFilename());
	        Path uploadPath = Paths.get(uploadDir);

	        if (!Files.exists(uploadPath)) {
	            try {
					Files.createDirectories(uploadPath);
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
	        }

	        try (InputStream inputStream = image.getInputStream()) {
	            Path filePath = uploadPath.resolve(filename);
	            Files.copy(inputStream, filePath, StandardCopyOption.REPLACE_EXISTING);
	        } catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
	        String imageUrl = ServletUriComponentsBuilder.fromCurrentContextPath()
	                .path("/images/")
	                .path(filename)
	                .toUriString();
		    Category category = this.categoryRepository.findByName(categoryTitle);
	        Product product = new Product();
	        product.setName(title);
	        product.setDescription(description);
	        product.setCategory(category);
	        product.setPrice(price);
	        product.setImageUrl(imageUrl);
	        Product savedProduct = productRepository.save(product);
	        return ResponseEntity.ok(savedProduct);
	}

}
