package com.Silvano.TechShop.controllers;

import com.Silvano.TechShop.entities.Categoria;
import com.Silvano.TechShop.services.CategoriaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
import java.util.List;

@RestController
@RequestMapping("/categorias")
public class CategoriaController {

    @Autowired
    private CategoriaService service;

/*    @PostMapping
    public Categoria criar(@RequestBody Categoria categoria){
        return service.criar(categoria);
    }*/

    @GetMapping("/all")
    public List<Categoria> listar() {
        return service.listar();
    }

    @GetMapping(value = "/{id}")
    public ResponseEntity<Categoria> buscarId(@PathVariable Integer id) {
        Categoria categoria = service.buscarPorId(id);
        return ResponseEntity.ok().body(categoria);
    }

    @PostMapping
    public ResponseEntity<Void> inserir(@RequestBody Categoria categoria){
        categoria = service.criar(categoria);
        URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}")
                .buildAndExpand(categoria.getId()).toUri();
        return ResponseEntity.created(uri).build();
    }
}
