package com.SpicaLabs.tack.dto.request;

import com.SpicaLabs.tack.entity.Order;
import com.SpicaLabs.tack.entity.Product;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class OrderItemReqDto {

    private Long productId;

    private Order order;

    private Integer quantity;
    private BigDecimal price;
}
