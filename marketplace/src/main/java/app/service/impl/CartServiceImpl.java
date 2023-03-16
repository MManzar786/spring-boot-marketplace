package app.service.impl;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import app.common.exception.CustomException;
import app.dto.AddCartRequest;
import app.dto.AddCartResponse;
import app.dto.AuthenticationResponse;
import app.dto.DeleteCartResponse;
import app.model.Cart;
import app.model.CartItem;
import app.repository.CartItemRepository;
import app.repository.CartRepository;
import app.repository.UserRepository;
import app.repository.ProductRepository;
import app.service.CartService;
import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class CartServiceImpl implements CartService {
	private final CartRepository cartRepository;
	private final CartItemRepository cartItemRepository;
	private final UserRepository userRepository;
	private final ProductRepository productRepository;

	@Override
	public AddCartResponse addCartItem(AddCartRequest request) {
		try {
			var user = userRepository.findByEmail(request.getEmail()).orElseThrow();
			var cart = new Cart();
			cart.setUser(user);
			var cartAdded = cartRepository.save(cart);
			var cartItem = new CartItem();
			var product = productRepository.findById(request.getProductId());
			cartItem.setCart(cartAdded);
			cartItem.setProduct(product.get());
			cartItem.setQuantity(request.getQuantity());
			cartItemRepository.save(cartItem);
			return AddCartResponse.builder().cartItem(cartItem).build();
		} catch (Exception e) {
			throw new CustomException("Invalid items supplied", HttpStatus.CONFLICT);
		}
	}

	@Override
	public DeleteCartResponse deleteCartItem(Long cartId) {
		try {
			cartItemRepository.findById(cartId).orElseThrow();
			cartItemRepository.deleteById(cartId);
			return DeleteCartResponse.builder().status("success").build();
		} catch (Exception e) {
			throw new CustomException("Cart Items Not Found", HttpStatus.NOT_FOUND);
		}
	}

}
