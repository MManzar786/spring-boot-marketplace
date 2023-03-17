package app.controller;

import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.config.annotation.method.configuration.EnableMethodSecurity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import app.common.exception.CustomException;
import app.dto.AddCartRequest;
import app.dto.PaginatedResponse;
import app.model.Product;
import app.service.CartService;
import lombok.RequiredArgsConstructor;

@RestController
@RequestMapping("carts")
@RequiredArgsConstructor
@EnableMethodSecurity()
public class CartController {
	private final CartService cartService;

	@GetMapping("/{userId}")
	public ResponseEntity<?> getCartItemsByUserId(
	        @PathVariable Long userId) {
		try {
	    return cartService.findAll(userId);
		} catch (CustomException ex) {
			return ResponseEntity.status(ex.getHttpStatus().value()).body(ex.getMessage());
		}
	    
	}


	@PostMapping("/add")
	public ResponseEntity<?> addCart(@RequestBody AddCartRequest request) {
		try {
			return ResponseEntity.ok(this.cartService.addCartItem(request));
		} catch (CustomException ex) {
			return ResponseEntity.status(ex.getHttpStatus().value()).body(ex.getMessage());
		}
	}

	@DeleteMapping("{id}")
	public ResponseEntity<?> deleteItem(@PathVariable("id") Long id) {
		try {
			return ResponseEntity.ok(this.cartService.deleteCartItem(id));
		} catch (CustomException ex) {
			return ResponseEntity.status(ex.getHttpStatus().value()).body(ex.getMessage());
		}
	}
}
