package com.nttdata.escuela.price.adapter;

import com.nttdata.escuela.price.api.price.PriceRequestDto;
import com.nttdata.escuela.price.api.price.PriceResponseDto;
import com.nttdata.escuela.price.entity.PriceEntity;
import lombok.experimental.UtilityClass;

import java.util.List;
import java.util.stream.Collectors;

@UtilityClass
public class PriceAdapter {


    public static PriceResponseDto toDto (final PriceEntity priceEntity) {
        if (priceEntity == null) {
            return null;
        }
        return PriceResponseDto.builder().id(priceEntity.getId())
                .articuloId(priceEntity.getArticuloId())
                .paisId(priceEntity.getPaisId())
                .valor(priceEntity.getValor())
                .build();
    }
    public static List<PriceResponseDto> toDto (final List<PriceEntity> priceEntities) {
        return priceEntities.stream()
                .map(PriceAdapter::toDto)
                .collect(Collectors.toList());
    }
    public static PriceEntity toEntity (final PriceRequestDto priceRequestDto, final Integer priceId) {
        return PriceEntity.builder()
                .id(priceId)
                .articuloId(priceRequestDto.getArticuloId())
                .paisId(priceRequestDto.getPaisId())
                .valor(priceRequestDto.getValor())
                .build();
    }

    public static PriceEntity toEntity (final PriceRequestDto priceRequestDto) {
        return toEntity(priceRequestDto, null);
    }

}
