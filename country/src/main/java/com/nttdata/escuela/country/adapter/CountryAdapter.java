package com.nttdata.escuela.country.adapter;

import com.nttdata.escuela.country.api.CountryRequestDto;
import com.nttdata.escuela.country.api.CountryResponseDto;
import com.nttdata.escuela.country.entity.CountryEntity;
import lombok.experimental.UtilityClass;

import java.util.List;

@UtilityClass
public class CountryAdapter {
    public static List<CountryResponseDto> toDto (final List<CountryEntity> countryEntities) {
        return countryEntities.stream()
                .map(CountryAdapter::toDto)
                .toList();
    }

    public static CountryResponseDto toDto (final CountryEntity countryEntity) {
        if (countryEntity == null) {
            return null;
        }
        return CountryResponseDto.builder()
                .id(countryEntity.getId())
                .nombre(countryEntity.getNombre())
                .moneda(countryEntity.getMoneda())
                .build();
    }

    public static CountryEntity toEntity (final CountryRequestDto countryRequestDto, final Integer id) {
        return CountryEntity.builder()
                .id(id)
                .nombre(countryRequestDto.getNombre())
                .moneda(countryRequestDto.getMoneda())
                .build();
    }

    public static CountryEntity toEntity (final CountryRequestDto countryRequestDto) {
        return toEntity(countryRequestDto, null);
    }
}
