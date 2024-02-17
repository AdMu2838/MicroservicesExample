package com.nttdata.escuela.article.controller;

import com.nttdata.escuela.article.adapter.ArticleAdapter;
import com.nttdata.escuela.article.api.ArticleRequestDto;
import com.nttdata.escuela.article.api.ArticleResponseDto;
import com.nttdata.escuela.article.api.ArticleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/article")
public class ArticleController {
    @Autowired
    private ArticleService articleService;
    @GetMapping
    public ResponseEntity<List<ArticleResponseDto>> getArticles() {
        return ResponseEntity.ok(ArticleAdapter.toDto(this.articleService.getAll()));
    }

    @PostMapping
    public ResponseEntity<Void> postArticle(@RequestBody ArticleRequestDto articleRequestDto) {
        this.articleService.create(ArticleAdapter.toEntity(articleRequestDto));
        return ResponseEntity.noContent().build();
    }

    @GetMapping("/{id}")
    public ResponseEntity<ArticleResponseDto> getArticle(@PathVariable Integer id) {
        return ResponseEntity.ok(ArticleAdapter.toDto(this.articleService.getById(id)));
    }

    @PutMapping("/{id}")
    public ResponseEntity<Void> putArticle(@PathVariable("id") Integer idArticle, @RequestBody ArticleRequestDto articleRequestDto) {
        this.articleService.update(ArticleAdapter.toEntity(articleRequestDto, idArticle));
        return ResponseEntity.noContent().build();
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteArticle(@PathVariable("id") Integer idArticle) {
        this.articleService.deleteById(idArticle);
        return ResponseEntity.noContent().build();
    }

    @GetMapping("/exists/{id}")
    public ResponseEntity<Boolean> existArticleById(@PathVariable("id") Integer idArticle) {
        return ResponseEntity.ok(this.articleService.existById(idArticle));
    }

}
