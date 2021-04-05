package com.Silvano.TechShop.dto;

import com.Silvano.TechShop.entities.Categoria;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

@NoArgsConstructor
@Data
public class CategoriaDto implements Serializable {

    private Integer id;
    private String nome;

    public CategoriaDto(Categoria categoria){
        id = categoria.getId();
        nome = categoria.getNome();
    }
}
