package app.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import app.model.Cart;

public interface CartRepository extends JpaRepository<Cart, Long>{
	

	@Query("SELECT c FROM Cart c WHERE c.user.id = :userId")
    Cart findByUser(@Param("userId") Long userId);

}
