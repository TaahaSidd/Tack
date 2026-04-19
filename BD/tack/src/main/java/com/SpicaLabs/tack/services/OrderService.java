package com.SpicaLabs.tack.services;

import com.SpicaLabs.tack.Mapper.DtoMapper;
import com.SpicaLabs.tack.dto.request.OrderItemReqDto;
import com.SpicaLabs.tack.dto.request.OrderReqDto;
import com.SpicaLabs.tack.dto.response.OrderRespDto;
import com.SpicaLabs.tack.entity.Order;
import com.SpicaLabs.tack.entity.OrderItem;
import com.SpicaLabs.tack.entity.Product;
import com.SpicaLabs.tack.repository.OrderRepo;
import com.SpicaLabs.tack.repository.ProductRepo;
import jakarta.persistence.EntityNotFoundException;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
@RequiredArgsConstructor
public class OrderService {

    private final OrderRepo orderRepo;
    private final DtoMapper dtoMapper;
    private final ProductRepo productRepo;

    @Transactional
    public OrderRespDto createOrder(OrderReqDto req) {

        //Validation
        for (OrderItemReqDto item : req.getOrderItems()) {
            Product product = productRepo
                    .findById(item.getProductId())
                    .orElseThrow(() -> new EntityNotFoundException("Product Id not found" + item.getProductId()));

            if (product.getStockQuantity() < item.getQuantity()) {
                throw new IllegalArgumentException(
                        String.format(
                                "Insufficient stock for product %s! Need %d, available %d",
                                product.getName(),
                                item.getQuantity(),
                                product.getStockQuantity()
                        )
                );
            }
        }

        //Order creation
        Order order = Order.builder()
                .customerName(req.getCustomerName())
                .orderDate(req.getOrderDate())
                .build();

        List<OrderItem> orderItems = new ArrayList<>();

        //Creating order items and deducting stock.
        for (OrderItemReqDto item : req.getOrderItems()) {
            Product product = productRepo.findById(item.getProductId()).orElseThrow(() -> new EntityNotFoundException(
                    "Product Id not found: " + item.getProductId()
            ));

            OrderItem orderItem = OrderItem.builder()
                    .product(product)
                    .quantity(item.getQuantity())
                    .price(item.getPrice())
                    .order(order)
                    .build();

            orderItems.add(orderItem);

            product.setStockQuantity(
                    product.getStockQuantity() - item.getQuantity()
            );

            productRepo.save(product);
        }

        order.setOrderItems(orderItems);
        Order savedOrder = orderRepo.save(order);

        return dtoMapper.toOrderRespDto(savedOrder);

    }
}
