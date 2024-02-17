package com.nttdata.escuela.price.api.price;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;

@Getter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class PriceRequestDto {

    private Integer articuloId;
    private Integer paisId;
    private BigDecimal valor;
}
