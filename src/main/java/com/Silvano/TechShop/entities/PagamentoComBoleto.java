package com.Silvano.TechShop.entities;

import com.Silvano.TechShop.enuns.EstadoPagamento;
import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Column;
import javax.persistence.Entity;
import java.util.Date;
@Entity
@Data
@NoArgsConstructor
public class PagamentoComBoleto extends Pagamento {

    @Column(name = "data_vencimento")
    @JsonFormat(pattern = "dd/MM/yyyy")
    private Date dataVencimento;

    @Column(name = "data_pagamento")
    @JsonFormat(pattern = "dd/MM/yyyy HH:mm")
    private Date dataPagmento;

    public PagamentoComBoleto(Integer id, EstadoPagamento status, Pedido pedido, Date dataVencimento, Date dataPagmento) {
        super(id, status, pedido);
        this.dataVencimento = dataVencimento;
        this.dataPagmento = dataPagmento;
    }
}
