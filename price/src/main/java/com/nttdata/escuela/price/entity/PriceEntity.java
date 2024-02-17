package com.nttdata.escuela.price.entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.relational.core.mapping.Table;

import java.math.BigDecimal;


@Data
@Builder
@Table("precio")
@NoArgsConstructor
@AllArgsConstructor
public class PriceEntity {
    @Id
    private Integer id;
    private Integer articuloId;
    private Integer paisId;
    private BigDecimal valor;
}
