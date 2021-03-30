package com.Silvano.TechShop.services;

import com.Silvano.TechShop.entities.Pedido;
import com.Silvano.TechShop.exceptions.ObjectNotFoundException;
import com.Silvano.TechShop.repositories.PedidoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PedidoService {

    @Autowired
    private PedidoRepository repository;

    public Pedido criar(Pedido pedido) {
        return repository.save(pedido);
    }

    public List<Pedido> listar() {
        return repository.findAll();
    }

    public Pedido buscarPorId(Integer id) {
        return repository.findById(id).orElseThrow(() -> new ObjectNotFoundException(
                String.format("Pedido não encontrado! ID: %d Tipo: %s", id, Pedido.class.getName())
        ));
    }
}
