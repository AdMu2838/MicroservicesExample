package com.nttdata.escuela.price.repository;

import com.nttdata.escuela.price.entity.PriceEntity;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface PriceJdbcRepository extends CrudRepository<PriceEntity, Integer>{
    List<PriceEntity> findAll();
    List<PriceEntity> findAllByArticuloId(Integer articleId);
    List<PriceEntity> findAllByPaisId(Integer countryId);
}
