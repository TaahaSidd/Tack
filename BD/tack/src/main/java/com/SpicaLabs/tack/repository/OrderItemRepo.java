package com.SpicaLabs.tack.repository;

import com.SpicaLabs.tack.entity.OrderItem;
import org.springframework.data.jpa.repository.JpaRepository;

public interface OrderItemRepo extends JpaRepository<OrderItem, Long> {
}
