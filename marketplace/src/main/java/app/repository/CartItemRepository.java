package app.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import app.model.Cart;
import app.model.CartItem;

public interface CartItemRepository extends JpaRepository<CartItem,Long>{

	List<CartItem> findAllByCartId(Long cart);

	@Query("SELECT ci FROM CartItem ci WHERE ci.cart = :cart AND ci.product.id = :productId")
	Optional<CartItem> findByCartAndProduct(@Param("cart") Cart cart, @Param("productId") Long productId);



}
