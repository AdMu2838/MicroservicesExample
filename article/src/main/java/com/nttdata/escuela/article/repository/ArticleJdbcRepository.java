package com.nttdata.escuela.article.repository;

import com.nttdata.escuela.article.entity.ArticleEntity;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface ArticleJdbcRepository extends CrudRepository<ArticleEntity, Integer> {
    List<ArticleEntity> findAll();
}
