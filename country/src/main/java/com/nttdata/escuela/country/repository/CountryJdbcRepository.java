package com.nttdata.escuela.country.repository;

import com.nttdata.escuela.country.entity.CountryEntity;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CountryJdbcRepository extends CrudRepository<CountryEntity, Integer> {
    List<CountryEntity> findAll();
}
