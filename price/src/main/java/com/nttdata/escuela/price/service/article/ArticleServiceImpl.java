package com.nttdata.escuela.price.service.article;

import com.nttdata.escuela.price.api.article.ArticleService;
import com.nttdata.escuela.price.client.ArticleFeignClient;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.Optional;

@Service
public class ArticleServiceImpl implements ArticleService {
    @Autowired
    private ArticleFeignClient articleFeignClient;

    @Autowired
    private RestTemplate restTemplate;
    @Override
    public boolean existsById(Integer id) {
        return this.getResponse(this.restTemplate.getForEntity("http://article-service/api/v1/article/exists/"
                + id, Boolean.class));
    }
    private boolean getResponse(final ResponseEntity<Boolean> response){
        return Optional.ofNullable(response.getBody())
                .orElse(this.fallbackMethod());
    }
    private boolean fallbackMethod() {
        return false;
    }
}
