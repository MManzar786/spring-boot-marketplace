package app.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import app.model.OrderItem;

public interface OrderItemRepository extends JpaRepository<OrderItem,Long>{

}
