package com.Silvano.TechShop.enuns;

import lombok.AllArgsConstructor;

@AllArgsConstructor
public enum TipoCliente {

    PESSOA_FISICA(1, "Pessoa física"),
    PESSOA_JURIDICA(2, "Pessoa Juridica");

    private int codigo;
    private String descricao;

    public int getCodigo() {
        return codigo;
    }

    public String getDescricao() {
        return descricao;
    }

    public static TipoCliente toenum(Integer codigo) {
        if (codigo == null) {
            return null;
        }
        for (TipoCliente i : TipoCliente.values()) {
            if (codigo.equals(i.getCodigo())) {
                return i;
            }
        }
        throw new IllegalArgumentException(String.format("Id inválido: %d", codigo));
    }
}
