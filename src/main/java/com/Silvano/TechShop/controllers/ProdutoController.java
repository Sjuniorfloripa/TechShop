package com.Silvano.TechShop.controllers;

import com.Silvano.TechShop.entities.Produto;
import com.Silvano.TechShop.services.ProdutoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/produtos")
public class ProdutoController {

    @Autowired
    private ProdutoService service;

    @PostMapping
    public Produto criar(@RequestBody Produto produto){
        return service.criar(produto);
    }

    @GetMapping("/all")
    public List<Produto> list(){
        return service.list();
    }

    @GetMapping(value = "/{id}")
    public ResponseEntity<Produto> buscarId(@PathVariable Integer id){
        Produto produto = service.buscarPorId(id);
        return ResponseEntity.ok().body(produto);
    }
}
