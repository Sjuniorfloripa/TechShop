package com.Silvano.TechShop.services;

import com.Silvano.TechShop.entities.Categoria;
import com.Silvano.TechShop.repositories.CategoriaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CategoriaService {

    @Autowired
    private CategoriaRepository repository;

    public List<Categoria> listar(){
        return repository.findAll();
    }
}
