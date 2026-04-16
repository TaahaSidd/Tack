package com.SpicaLabs.tack.dto.response;

import java.time.LocalDateTime;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class RawMaterialRespDto {

    private Long id;

    private String name;

    private Double quantityKg;

    private Double costPerKg;

    private String supplier;

    private LocalDateTime createdAt;
}
