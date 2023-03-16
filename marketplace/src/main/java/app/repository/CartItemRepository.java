package app.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import app.model.CartItem;

public interface CartItemRepository extends JpaRepository<CartItem,Long>{

}
