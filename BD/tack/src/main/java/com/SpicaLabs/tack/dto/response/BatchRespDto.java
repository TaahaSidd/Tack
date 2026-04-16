package com.SpicaLabs.tack.dto.response;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDate;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class BatchRespDto {

    private Long id;

    private Double beadsUsedKg;
    private Double sticksProduced;
    private Double wastageKg;

    private LocalDate date;

    private Long rawMaterialId;
}
