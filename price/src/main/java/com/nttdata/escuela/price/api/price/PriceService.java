package com.nttdata.escuela.price.api.price;

import com.nttdata.escuela.price.entity.PriceEntity;

import java.util.List;

public interface PriceService {
    List<PriceEntity> getAll();
    void create(PriceEntity priceEntity);
    PriceEntity getById(Integer id);
    void update(PriceEntity priceEntity);
    void deleteById(Integer id);

    List<PriceEntity> listPricesByArticuloId(final Integer articleId);
    List<PriceEntity> listPricesByPaisId(final Integer countryId);
}
