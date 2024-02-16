package com.nttdata.escuela.article.api;

import com.nttdata.escuela.article.entity.ArticleEntity;

import java.util.List;

public interface ArticleService {
    List<ArticleEntity> getAll();
    void create(ArticleEntity articleEntity);
    ArticleEntity getById(Integer id);
    void update(ArticleEntity articleEntity);
    void deleteById(Integer id);
    boolean existById(Integer id);
}
