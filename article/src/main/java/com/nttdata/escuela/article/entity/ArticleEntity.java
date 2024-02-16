package com.nttdata.escuela.article.entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.relational.core.mapping.Table;

@Data
@Builder
@Table("articulo")
@NoArgsConstructor
@AllArgsConstructor
public class ArticleEntity {
    @Id
    private Integer id;
    private String nombre;
    private String color;
}
