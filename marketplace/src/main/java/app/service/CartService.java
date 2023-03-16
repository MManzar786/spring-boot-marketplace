package app.service;

import app.dto.AddCartRequest;
import app.dto.AddCartResponse;
import app.dto.DeleteCartResponse;

public interface CartService {

	DeleteCartResponse deleteCartItem(Long cartId);

	AddCartResponse addCartItem(AddCartRequest request);
	

}
