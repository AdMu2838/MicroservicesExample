package com.nttdata.escuela.country.controller;

import com.nttdata.escuela.country.adapter.CountryAdapter;
import com.nttdata.escuela.country.api.CountryRequestDto;
import com.nttdata.escuela.country.api.CountryResponseDto;
import com.nttdata.escuela.country.api.CountryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/country")
public class CountryController {
    @Autowired
    private CountryService countryService;

    @GetMapping
    public ResponseEntity<List<CountryResponseDto>> getCountries() {
        return ResponseEntity.ok(CountryAdapter.toDto(this.countryService.getAll()));
    }

    @PostMapping
    public ResponseEntity<Void> postCountry(@RequestBody CountryRequestDto countryRequestDto) {
        this.countryService.create(CountryAdapter.toEntity(countryRequestDto));
        return ResponseEntity.noContent().build();

    }

    @GetMapping("/{id}")
    public ResponseEntity<CountryResponseDto> getCountry(@PathVariable Integer id) {
        return ResponseEntity.ok(CountryAdapter.toDto(this.countryService.getById(id)));
    }

    @PutMapping("/{id}")
    public ResponseEntity<Void> putCountry(@PathVariable("id") Integer idCountry, @RequestBody CountryRequestDto countryRequestDto) {
        this.countryService.update(CountryAdapter.toEntity(countryRequestDto, idCountry));
        return ResponseEntity.noContent().build();
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteCountry(@PathVariable("id") Integer idCountry) {
        this.countryService.deleteById(idCountry);
        return ResponseEntity.noContent().build();
    }

    @GetMapping("/exists/{id}")
    public ResponseEntity<Boolean> existCountryById(@PathVariable("id") Integer idCountry) {
        return ResponseEntity.ok(this.countryService.existById(idCountry));
    }
}
