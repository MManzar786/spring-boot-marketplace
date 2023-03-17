package app.dto;

import java.math.BigDecimal;
import java.util.List;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class AddOrderRequest {
    private Long userId;
    private BigDecimal totalAmount;
    private List<OrderItemDto> orderItems;
}
