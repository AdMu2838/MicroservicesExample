package com.nttdata.escuela.price.service.country;

import com.nttdata.escuela.price.client.CountryFeignClient;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;


import com.nttdata.escuela.price.api.country.CountryService;
import org.springframework.web.client.RestTemplate;

import java.util.Optional;

@Service
public class CountryServiceImpl implements CountryService {
    @Autowired
    private CountryFeignClient countryFeignClient;
    @Autowired
    private RestTemplate restTemplate;

    @Override
    public boolean existsById(Integer id) {
        return this.getResponse(this.restTemplate.getForEntity("http://country-service/api/v1/country/exists/"
                        + id, Boolean.class));
    }
    private boolean getResponse(final ResponseEntity<Boolean> response) {
        return Optional.ofNullable(response.getBody())
                .orElse(this.fallbackMethod());
    }
    private boolean fallbackMethod() {
        return false;
    }
}
