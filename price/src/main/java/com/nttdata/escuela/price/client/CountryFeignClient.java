package com.nttdata.escuela.price.client;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@FeignClient(name = "country-service", path = "api/v1/country")
public interface CountryFeignClient {
    @GetMapping("exists/{id}")
    boolean existById(@PathVariable Integer id);
}
