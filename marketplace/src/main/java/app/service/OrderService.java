package app.service;

import java.util.List;

import app.dto.AddOrderRequest;
import app.dto.AddOrderResponse;
import app.model.OrderItem;

public interface OrderService {

	List<OrderItem> findAll();

	AddOrderResponse addOrders(AddOrderRequest orderDto);

}
