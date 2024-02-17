package com.nttdata.escuela.price.service.price;

import com.nttdata.escuela.price.api.price.PriceRepository;
import com.nttdata.escuela.price.api.price.PriceService;
import com.nttdata.escuela.price.entity.PriceEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PriceServiceImpl implements PriceService {
    @Autowired
    private PriceRepository priceRepository;


    @Override
    public List<PriceEntity> getAll() {
        return this.priceRepository.getAll();
    }

    @Override
    public void create(PriceEntity priceEntity) {
        if (priceEntity.getId() == null) {
            this.priceRepository.save(priceEntity);
        } else {
            throw new RuntimeException("No permitido");
        }
    }

    @Override
    public PriceEntity getById(Integer id) {
        return this.priceRepository.getById(id);
    }

    @Override
    public void update(PriceEntity priceEntity) {
        if (priceEntity.getId() != null) {
            this.priceRepository.save(priceEntity);
        } else {
            throw new RuntimeException("No permitido");
        }
    }

    @Override
    public void deleteById(Integer id) {
        this.priceRepository.deleteById(id);
    }

    @Override
    public List<PriceEntity> listPricesByArticuloId(Integer articleId) {
        return this.priceRepository.getAllByArticuloId(articleId);
    }

    @Override
    public List<PriceEntity> listPricesByPaisId(Integer countryId) {
        return this.priceRepository.getAllByPaisId(countryId);
    }
}
