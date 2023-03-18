package app.service.impl;

import java.time.LocalDateTime;
import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import app.common.exception.CustomException;
import app.common.utils.Constants;
import app.dto.AddOrderRequest;
import app.dto.AddOrderResponse;
import app.dto.OrderItemDto;
import app.dto.OrderResponse;
import app.model.Order;
import app.model.OrderItem;
import app.model.Product;
import app.model.User;
import app.repository.OrderItemRepository;
import app.repository.OrderRepository;
import app.repository.ProductRepository;
import app.repository.UserRepository;
import app.service.OrderService;
import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class OrderServiceImpl implements OrderService{
	private final OrderItemRepository orderItemRepository;
	private final OrderRepository orderRepository;
	private final UserRepository userRepository;
	private final ProductRepository productRepository;
	@Override
	public OrderResponse findAllOrders() {
		try {
		List<Order> orderItems= orderRepository.findAll();
		return OrderResponse.builder().orders(orderItems).build();
		}catch(Exception e) {
			throw new CustomException(e.getMessage(), HttpStatus.CONFLICT);
		}
	}
	@Override
	public AddOrderResponse addOrders(AddOrderRequest orderDto) {
		try {
			
			Order order = new Order();
	        order.setStatus(Constants.PLACED_ORDER_STATUS);
	        order.setCreatedAt(LocalDateTime.now());
	        Long userId = orderDto.getUserId();
	        User user = userRepository.findById(userId).orElseThrow();
	        order.setUser(user);
	        orderRepository.save(order);
	        for (OrderItemDto orderItemDto : orderDto.getOrderItems()) {
	            OrderItem orderItem = new OrderItem();
	            Product product = productRepository.findById(orderItemDto.getProductId()).orElseThrow();
	            orderItem.setProduct(product);
	            orderItem.setQuantity(orderItemDto.getQuantity());
	            orderItem.setOrder(order);
	            orderItemRepository.save(orderItem);
	        }
	        return AddOrderResponse.builder().success(true).build();
	       
		}catch(Exception e) {
			throw new CustomException(e.getMessage(), HttpStatus.CONFLICT);
		}
	}

}
