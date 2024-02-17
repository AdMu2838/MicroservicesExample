package com.nttdata.escuela.price.controller;

import com.nttdata.escuela.price.adapter.PriceAdapter;
import com.nttdata.escuela.price.api.price.PriceRequestDto;
import com.nttdata.escuela.price.api.price.PriceResponseDto;
import com.nttdata.escuela.price.api.price.PriceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/price")
public class PriceController {
    @Autowired
    private PriceService priceService;

    @GetMapping
    public ResponseEntity<List<PriceResponseDto>> getPrices() {
        return ResponseEntity.ok(PriceAdapter.toDto(this.priceService.getAll()));
    }
    @PostMapping
    public ResponseEntity<Void> postPrice(@RequestBody PriceRequestDto priceRequestDto) {
        this.priceService.create(PriceAdapter.toEntity(priceRequestDto));
        return ResponseEntity.noContent().build();
    }
    @GetMapping("/{id}")
    public ResponseEntity<PriceResponseDto> getPrice(@PathVariable Integer id) {
        return ResponseEntity.ok(PriceAdapter.toDto(this.priceService.getById(id)));
    }
    @PutMapping("/{id}")
    public ResponseEntity<Void> putPrice(@PathVariable("id") Integer idPrice, @RequestBody PriceRequestDto priceRequestDto) {
        this.priceService.update(PriceAdapter.toEntity(priceRequestDto, idPrice));
        return ResponseEntity.noContent().build();
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deletePrice(@PathVariable("id") Integer idPrice) {
        this.priceService.deleteById(idPrice);
        return ResponseEntity.noContent().build();
    }

    @GetMapping("/article/{articleId}")
    public ResponseEntity<List<PriceResponseDto>> getPricesByArticleId(@PathVariable Integer articleId) {
        return ResponseEntity.ok(PriceAdapter.toDto(this.priceService.listPricesByArticuloId(articleId)));
    }

    @GetMapping("/country/{countryId}")
    public ResponseEntity<List<PriceResponseDto>> getPricesByCountryId(@PathVariable Integer countryId) {
        return ResponseEntity.ok(PriceAdapter.toDto(this.priceService.listPricesByPaisId(countryId)));
    }
}
