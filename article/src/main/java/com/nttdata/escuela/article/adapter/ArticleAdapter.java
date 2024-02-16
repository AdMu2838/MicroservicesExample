package com.nttdata.escuela.article.adapter;

import com.nttdata.escuela.article.api.ArticleRequestDto;
import com.nttdata.escuela.article.api.ArticleResponseDto;
import com.nttdata.escuela.article.entity.ArticleEntity;
import lombok.experimental.UtilityClass;

import java.util.List;
import java.util.stream.Collectors;

@UtilityClass
public class ArticleAdapter {

    public static List<ArticleResponseDto> toDto(final List<ArticleEntity> articleEntities) {
        return articleEntities.stream()
                .map(ArticleAdapter::toDto)
                .collect(Collectors.toList());
    }

    public static ArticleResponseDto toDto(final ArticleEntity articleEntity) {
        if (articleEntity == null)
            return null;

        return ArticleResponseDto.builder()
                .id(articleEntity.getId())
                .nombre(articleEntity.getNombre())
                .color(articleEntity.getColor())
                .build();
    }
    public static ArticleEntity toEntity(final ArticleRequestDto articleRequestDto, final Integer articleId) {
        return ArticleEntity.builder()
                .id(articleId)
                .nombre(articleRequestDto.getNombre())
                .color(articleRequestDto.getColor())
                .build();
    }

    public static ArticleEntity toEntity(final ArticleRequestDto articleRequestDto) {
        return toEntity(articleRequestDto, null);
    }
}
