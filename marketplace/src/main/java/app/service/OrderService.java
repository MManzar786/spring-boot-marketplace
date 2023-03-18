package app.service;

import app.dto.AddOrderRequest;
import app.dto.AddOrderResponse;
import app.dto.OrderResponse;

public interface OrderService {

	OrderResponse findAllOrders();

	AddOrderResponse addOrders(AddOrderRequest orderDto);


}
