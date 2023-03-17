package app.service;

import java.util.List;

import org.springframework.http.ResponseEntity;

import app.dto.AddCartRequest;
import app.dto.AddCartResponse;
import app.dto.DeleteCartResponse;
import app.model.CartItem;

public interface CartService {

	DeleteCartResponse deleteCartItem(Long cartId);

	AddCartResponse addCartItem(AddCartRequest request);

	ResponseEntity<List<CartItem>> findAll(Long id);
	

}
