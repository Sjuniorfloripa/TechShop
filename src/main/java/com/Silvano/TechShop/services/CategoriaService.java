package com.Silvano.TechShop.services;

import com.Silvano.TechShop.entities.Categoria;
import com.Silvano.TechShop.exceptions.ObjectNotFoundException;
import com.Silvano.TechShop.repositories.CategoriaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CategoriaService {

    @Autowired
    private CategoriaRepository repository;

    public List<Categoria> listar() {
        return repository.findAll();
    }

    public Categoria buscarPorId(Integer id) {
        Optional<Categoria> categoria = repository.findById(id);
        return categoria.orElseThrow(() -> new ObjectNotFoundException(
                String.format("Categoria Não encotrada! ID: %d, Tipo: %s.", id, Categoria.class.getName())));
    }
}
