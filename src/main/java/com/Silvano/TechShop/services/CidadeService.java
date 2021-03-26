package com.Silvano.TechShop.services;

import com.Silvano.TechShop.entities.Cidade;
import com.Silvano.TechShop.exceptions.ObjectNotFoundException;
import com.Silvano.TechShop.repositories.CidadeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CidadeService {

    @Autowired
    private CidadeRepository repository;

    public List<Cidade> listar() {
        return repository.findAll();
    }

    public Cidade buscarPorId(Integer id) {
        return repository.findById(id).orElseThrow(() -> new ObjectNotFoundException(
                String.format("Cidade não encontrada! ID: %d, Tipo: %s", id, Cidade.class.getName())
        ));
    }
}
