package com.SpicaLabs.tack.dto.request;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;
import java.util.List;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class OrderReqDto {

    private String customerName;
    private LocalDate orderDate;

    private List<OrderItemReqDto> orderItems;
}
