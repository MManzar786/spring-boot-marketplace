package app.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.security.config.annotation.method.configuration.EnableMethodSecurity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import app.common.exception.CustomException;
import app.dto.AddOrderRequest;
import app.service.OrderService;
import lombok.RequiredArgsConstructor;

@RestController
@RequestMapping("orders")
@RequiredArgsConstructor
@EnableMethodSecurity()
public class OrderController {
	private final OrderService orderService;

	@GetMapping()
	public ResponseEntity<?> getAll() {
		try {
			return ResponseEntity.ok(orderService.findAll());
		} catch (CustomException ex) {
			return ResponseEntity.status(ex.getHttpStatus().value()).body(ex.getMessage());
		}
	}
	
	@PostMapping()
	public ResponseEntity<?> addOrders(@RequestBody AddOrderRequest orderDto) {
		try {
			return ResponseEntity.ok(orderService.addOrders(orderDto));
		} catch (CustomException ex) {
			return ResponseEntity.status(ex.getHttpStatus().value()).body(ex.getMessage());
		}
	}
}
