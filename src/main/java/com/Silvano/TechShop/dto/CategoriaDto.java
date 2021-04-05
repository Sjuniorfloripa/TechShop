package com.Silvano.TechShop.dto;

import com.Silvano.TechShop.entities.Categoria;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.validator.constraints.Length;

import javax.validation.constraints.NotEmpty;
import java.io.Serializable;

@NoArgsConstructor
@Data
public class CategoriaDto implements Serializable {

    private Integer id;

    @NotEmpty(message = "Preenchimento obrigatório!")
    @Length(min = 5, max = 80, message = "O tamanho deve ser entre 5 e 80 caracteres")
    private String nome;

    public CategoriaDto(Categoria categoria){
        id = categoria.getId();
        nome = categoria.getNome();
    }
}
