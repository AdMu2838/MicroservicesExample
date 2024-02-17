package com.nttdata.escuela.country.service;

import com.nttdata.escuela.country.api.CountryRepository;
import com.nttdata.escuela.country.api.CountryService;
import com.nttdata.escuela.country.entity.CountryEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CountryServiceImpl implements CountryService {
    @Autowired
    private CountryRepository countryRepository;
    @Override
    public List<CountryEntity> getAll() {
        return this.countryRepository.getAll();
    }

    @Override
    public void create(CountryEntity countryEntity) {
        if (countryEntity.getId() == null ) {
            this.countryRepository.save(countryEntity);
        } else {
            throw new RuntimeException("No permitido");
        }
    }

    @Override
    public CountryEntity getById(Integer id) {
        return this.countryRepository.getById(id);
    }

    @Override
    public void update(CountryEntity countryEntity) {
        if (countryEntity.getId() != null ) {
            this.countryRepository.save(countryEntity);
        } else {
            throw new RuntimeException("No permitido");
        }
    }

    @Override
    public void deleteById(Integer id) {
        this.countryRepository.deleteById(id);
    }

    @Override
    public boolean existById(Integer id) {
        return this.countryRepository.existById(id);
    }
}
