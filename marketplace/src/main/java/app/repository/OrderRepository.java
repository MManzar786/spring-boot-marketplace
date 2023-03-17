package app.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import app.model.Order;

public interface OrderRepository extends JpaRepository<Order,Long>{

}
