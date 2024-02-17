package com.nttdata.escuela.country.api;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class CountryRequestDto {

    private String nombre;

    private String moneda;
}
