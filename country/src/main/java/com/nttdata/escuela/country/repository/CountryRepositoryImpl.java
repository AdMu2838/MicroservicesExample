package com.nttdata.escuela.country.repository;

import com.nttdata.escuela.country.api.CountryRepository;
import com.nttdata.escuela.country.entity.CountryEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class CountryRepositoryImpl implements CountryRepository {
    @Autowired
    private CountryJdbcRepository countryJdbcRepository;


    @Override
    public List<CountryEntity> getAll() {
        return this.countryJdbcRepository.findAll();
    }

    @Override
    public void save(CountryEntity countryEntity) {
        this.countryJdbcRepository.save(countryEntity);
    }

    @Override
    public CountryEntity getById(Integer id) {
        return this.countryJdbcRepository.findById(id).orElse(null);
    }

    @Override
    public void deleteById(Integer id) {
        this.countryJdbcRepository.delete(CountryEntity.builder().id(id).build());
    }

    @Override
    public boolean existById(Integer id) {
        return this.countryJdbcRepository.existsById(id);
    }
}
