package app.repository;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import app.model.Product;

public interface ProductRepository extends JpaRepository<Product, Long> {
	@Query("SELECT p FROM Product p WHERE LOWER(p.name) LIKE LOWER(CONCAT('%', :title, '%'))")
    Page<Product> findByTitle(@Param("title") String name, Pageable pageable);
	
	@Query("SELECT p FROM Product p WHERE p.category.id = :categoryId")
    Page<Product> findByCategory(@Param("categoryId") Long category, Pageable pageable);
	
}