package com.nttdata.escuela.country.api;

import com.nttdata.escuela.country.entity.CountryEntity;

import java.util.List;

public interface CountryRepository {
    List<CountryEntity> getAll();

    void save(CountryEntity countryEntity);
    CountryEntity getById(Integer id);
    void deleteById(Integer id);
    boolean existById(Integer id);

}
