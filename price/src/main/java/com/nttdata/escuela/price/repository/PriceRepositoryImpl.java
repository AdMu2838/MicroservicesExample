package com.nttdata.escuela.price.repository;

import com.nttdata.escuela.price.api.price.PriceRepository;
import com.nttdata.escuela.price.entity.PriceEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class PriceRepositoryImpl implements PriceRepository {
    @Autowired
    private PriceJdbcRepository priceJdbcRepository;


    @Override
    public List<PriceEntity> getAll() {
        return this.priceJdbcRepository.findAll();
    }

    @Override
    public void save(PriceEntity priceEntity) {
        this.priceJdbcRepository.save(priceEntity);
    }

    @Override
    public PriceEntity getById(Integer id) {
        return this.priceJdbcRepository.findById(id)
                .orElse(null);
    }

    @Override
    public void deleteById(Integer id) {
        this.priceJdbcRepository.delete(PriceEntity.builder().id(id).build());
    }

    @Override
    public List<PriceEntity> getAllByArticuloId(Integer articleId) {
        return this.priceJdbcRepository.findAllByArticuloId(articleId);
    }

    @Override
    public List<PriceEntity> getAllByPaisId(Integer countryId) {
        return this.priceJdbcRepository.findAllByPaisId(countryId);
    }


}
