package app.dto;

import java.util.List;

import app.model.Order;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class OrderResponse {
	private List<Order> orders;
}



