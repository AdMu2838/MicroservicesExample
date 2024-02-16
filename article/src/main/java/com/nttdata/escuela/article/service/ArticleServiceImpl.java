package com.nttdata.escuela.article.service;

import com.nttdata.escuela.article.api.ArticleRepository;
import com.nttdata.escuela.article.api.ArticleService;
import com.nttdata.escuela.article.entity.ArticleEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ArticleServiceImpl implements ArticleService {
    @Autowired
    private ArticleRepository articleRepository;
    @Override
    public List<ArticleEntity> getAll() {
        return this.articleRepository.getAll();
    }

    @Override
    public void create(ArticleEntity articleEntity) {
        if (articleEntity.getId() == null) {
            this.articleRepository.save(articleEntity);
        } else {
            throw new RuntimeException("No permitido");
        }
    }

    @Override
    public ArticleEntity getById(Integer id) {
        return this.articleRepository.getById(id);
    }

    @Override
    public void update(ArticleEntity articleEntity) {
        if (articleEntity.getId() != null) {
            this.articleRepository.save(articleEntity);
        } else {
            throw new RuntimeException("No permitido");
        }
    }

    @Override
    public void deleteById(Integer id) {
        this.articleRepository.deleteById(id);
    }

    @Override
    public boolean existById(Integer id) {
        return this.articleRepository.existById(id);
    }
}
