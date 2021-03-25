package com.Silvano.TechShop.controllers;

import com.Silvano.TechShop.entities.Categoria;
import com.Silvano.TechShop.services.CategoriaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/categorias")
public class CategoriaController {

    @Autowired
    private CategoriaService service;

    @GetMapping("/all")
    public List<Categoria> listar(){
        return service.listar();
    }
}
