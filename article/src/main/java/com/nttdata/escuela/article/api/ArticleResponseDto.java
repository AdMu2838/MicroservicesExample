package com.nttdata.escuela.article.api;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class ArticleResponseDto {
    private Integer id;
    private String nombre;
    private String color;
}
