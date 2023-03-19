package app.service.impl;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import app.common.exception.CustomException;
import app.common.utils.Constants;
import app.dto.AddCartRequest;
import app.dto.AddCartResponse;
import app.dto.AuthenticationResponse;
import app.dto.DeleteCartResponse;
import app.model.Cart;
import app.model.CartItem;
import app.model.User;
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
			User user = userRepository.findById(request.getUserId()).orElseThrow();
			Cart cart = cartRepository.findByUser(user.getId());
			if (cart == null) {
				cart = new Cart();
				cart.setUser(user);
				cart = cartRepository.save(cart);
			}
			  var cartItemOptional = cartItemRepository.findByCartAndProduct(cart, request.getProductId());
		        if (cartItemOptional.isPresent()) {
		            var cartItem = cartItemOptional.get();
		            cartItem.setQuantity(cartItem.getQuantity() + request.getQuantity());
		            cartItemRepository.save(cartItem);
		            return AddCartResponse.builder().cartItem(cartItem).build();
		        }
			var cartItem = new CartItem();
			var product = productRepository.findById(request.getProductId());
			cartItem.setCart(cart);
			cartItem.setProduct(product.get());
			cartItem.setQuantity(request.getQuantity());
			cartItemRepository.save(cartItem);
			return AddCartResponse.builder().cartItem(cartItem).build();
		} catch (Exception e) {
			throw new CustomException(e.getMessage(), HttpStatus.CONFLICT);
		}
	}

	@Override
	public DeleteCartResponse deleteCartItem(Long cartId) {
		try {
			cartItemRepository.findById(cartId).orElseThrow();
			cartItemRepository.deleteById(cartId);
			return DeleteCartResponse.builder().status("success").build();
		} catch (Exception e) {
			throw new CustomException(Constants.CART_ITENS_NOT_FOUND_MESSAGE, HttpStatus.NOT_FOUND);
		}
	}

	@Override
	public ResponseEntity<List<CartItem>> findAll(Long id) {
		try {
			var user = userRepository.findById(id).orElseThrow();
			Cart cart = cartRepository.findByUser(id);
			var carItems = cartItemRepository.findAllByCartId(cart.getId());
			return ResponseEntity.ok(carItems);

		} catch (Exception e) {
			throw new CustomException(e.getMessage(), HttpStatus.NOT_FOUND);
		}
	}

}
