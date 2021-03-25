package com.Silvano.TechShop.services;

import com.Silvano.TechShop.entities.Produto;
import com.Silvano.TechShop.exceptions.ObjectNotFoundException;
import com.Silvano.TechShop.repositories.ProdutoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ProdutoService {

    @Autowired
    private ProdutoRepository repository;

    public List<Produto> list() {
        return repository.findAll();
    }

    public Produto buscarPorId(Integer id) {
        Optional<Produto> produto = repository.findById(id);
        return produto.orElseThrow(() -> new ObjectNotFoundException
                (String.format("Produto não encontrado! ID: %d, Tipo: %s.", id, Produto.class.getName())));
    }
}
