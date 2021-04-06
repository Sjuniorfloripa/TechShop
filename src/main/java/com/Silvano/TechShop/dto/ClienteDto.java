package com.Silvano.TechShop.dto;

import com.Silvano.TechShop.entities.Cliente;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.validator.constraints.Length;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotEmpty;
import java.io.Serializable;

@NoArgsConstructor
@Data
public class ClienteDto implements Serializable {

    private Integer id;

    @NotEmpty(message = "Preenchimento obrigatório!")
    @Length(min = 5,max = 120, message = "O tamanho deve ser entre 5 a 120 caracteres.")
    private String nome;

    @NotEmpty(message = "Preenchimento obrigatório!")
    @Email(message = "Email inválido")
    private String email;

    public ClienteDto(Cliente cliente) {
        id = cliente.getId();
        nome = cliente.getNome();
        email = cliente.getEmail();
    }
}
