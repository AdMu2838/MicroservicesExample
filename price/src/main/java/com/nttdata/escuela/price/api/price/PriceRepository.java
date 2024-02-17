package com.nttdata.escuela.price.api.price;

import com.nttdata.escuela.price.entity.PriceEntity;

import java.util.List;

public interface PriceRepository {
    List<PriceEntity> getAll();
    void save(PriceEntity priceEntity);
    PriceEntity getById(Integer id);
    void deleteById(Integer id);
    List<PriceEntity> getAllByArticuloId(Integer articleId);
    List<PriceEntity> getAllByPaisId(Integer countryId);

}
