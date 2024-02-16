package com.nttdata.escuela.article.repository;

import com.nttdata.escuela.article.api.ArticleRepository;
import com.nttdata.escuela.article.entity.ArticleEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;
@Repository
public class ArticleRepositoryImpl implements ArticleRepository {
    @Autowired
    private ArticleJdbcRepository articleJdbcRepository;
    @Override
    public List<ArticleEntity> getAll() {
        return this.articleJdbcRepository.findAll();
    }

    @Override
    public void save(ArticleEntity articleEntity) {
        this.articleJdbcRepository.save(articleEntity);
    }

    @Override
    public ArticleEntity getById(Integer id) {
        return this.articleJdbcRepository.findById(id).orElse(null);
    }

    @Override
    public void deleteById(Integer id) {
        this.articleJdbcRepository.delete(ArticleEntity.builder().id(id).build());
    }

    @Override
    public boolean existById(Integer id) {
        return this.articleJdbcRepository.existsById(id);
    }
}
