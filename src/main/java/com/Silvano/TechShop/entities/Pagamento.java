package com.Silvano.TechShop.entities;

import com.Silvano.TechShop.enuns.EstadoPagamento;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Table(name = "pagamento")
@Inheritance(strategy = InheritanceType.JOINED)
@Data
@NoArgsConstructor
@AllArgsConstructor
public abstract class Pagamento implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(name = "status")
    private Integer status;

    @OneToOne
    @JoinColumn(name = "pedido_id")
    @MapsId
    private Pedido pedido;

    public Pagamento(Integer id, EstadoPagamento status, Pedido pedido) {
        this.id = id;
        this.status = status.getCodigo();
        this.pedido = pedido;
    }

    public EstadoPagamento getStatus() {
        return EstadoPagamento.toEnum(status);
    }

    public void setStatus(EstadoPagamento status) {
        this.status = status.getCodigo();
    }
}
