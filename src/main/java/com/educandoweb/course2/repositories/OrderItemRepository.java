package com.educandoweb.course2.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.educandoweb.course2.entities.OrderItem;

public interface OrderItemRepository extends JpaRepository<OrderItem, Long>{	

}
