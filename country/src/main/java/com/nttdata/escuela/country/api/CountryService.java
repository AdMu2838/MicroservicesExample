package com.nttdata.escuela.country.api;

import com.nttdata.escuela.country.entity.CountryEntity;

import java.util.List;

public interface CountryService {
    List<CountryEntity> getAll();
    void create(CountryEntity countryEntity);
    CountryEntity getById(Integer id);
    void update(CountryEntity countryEntity);
    void deleteById(Integer id);
    boolean existById(Integer id);

}
