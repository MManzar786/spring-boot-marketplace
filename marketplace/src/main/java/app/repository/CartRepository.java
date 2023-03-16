package app.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import app.model.Cart;

public interface CartRepository extends JpaRepository<Cart, Long>{

}
