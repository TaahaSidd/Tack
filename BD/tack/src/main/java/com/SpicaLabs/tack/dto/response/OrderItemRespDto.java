package com.SpicaLabs.tack.dto.response;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class OrderItemRespDto {

    private Long id;

    private Long productId;
    private String productName;

    private Integer quantity;
    private BigDecimal price;
}
