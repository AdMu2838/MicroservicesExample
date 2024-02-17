package com.nttdata.escuela.country.entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.relational.core.mapping.Table;

@Data
@Builder
@Table("pais")
@NoArgsConstructor
@AllArgsConstructor
public class CountryEntity {
    @Id
    private Integer id;

    private String nombre;

    private String moneda;
}
