package com.Silvano.TechShop.services;

import com.Silvano.TechShop.entities.Cidade;
import com.Silvano.TechShop.entities.Estado;
import com.Silvano.TechShop.exceptions.ObjectNotFoundException;
import com.Silvano.TechShop.repositories.EstadoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EstadoService {

    @Autowired
    private EstadoRepository repository;

    public List<Estado> listar() {
        return repository.findAll();
    }

    public Estado buscarPorId(Integer id) {
        return repository.findById(id).orElseThrow(() -> new ObjectNotFoundException
                (String.format("Estado não encontrado! ID: %d Tipo: %s.", id, Cidade.class.getName())));
    }
}
