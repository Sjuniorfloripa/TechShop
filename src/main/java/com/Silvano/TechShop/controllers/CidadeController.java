package com.Silvano.TechShop.controllers;

import com.Silvano.TechShop.entities.Cidade;
import com.Silvano.TechShop.services.CidadeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/cidades")
public class CidadeController {

    @Autowired
    private CidadeService service;

    @GetMapping("/all")
    public List<Cidade> listar(){
        return service.listar();
    }

    @GetMapping(value = "/{id}")
    public ResponseEntity<Cidade> buscarId(@PathVariable Integer id){
        Cidade cidade = service.buscarPorId(id);
        return ResponseEntity.ok().body(cidade);
    }
}
