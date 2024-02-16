package com.nttdata.escuela.article.api;

import com.nttdata.escuela.article.entity.ArticleEntity;

import java.util.List;

public interface ArticleRepository {
    List<ArticleEntity> getAll();
    void save(ArticleEntity articleEntity);
    ArticleEntity getById(Integer id);
    void deleteById(Integer id);
    boolean existById(Integer id);
}
