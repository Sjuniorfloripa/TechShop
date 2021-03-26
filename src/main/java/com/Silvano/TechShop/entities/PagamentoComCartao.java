package com.Silvano.TechShop.entities;

import com.Silvano.TechShop.enuns.EstadoPagamento;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;

@Entity
@Data
@NoArgsConstructor
public class PagamentoComCartao extends Pagamento {

    private Integer numeroDeParcelas;

    public PagamentoComCartao(Integer id, EstadoPagamento status, Pedido pedido, Integer numeroDeParcelas) {
        super(id, status, pedido);
        this.numeroDeParcelas = numeroDeParcelas;
    }
}
