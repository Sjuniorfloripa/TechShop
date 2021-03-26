package com.Silvano.TechShop.controllers;

import com.Silvano.TechShop.entities.Endereco;
import com.Silvano.TechShop.services.EnderecoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/enderecos")
public class EnderecoController {

    @Autowired
    private EnderecoService service;

    @GetMapping("/all")
    public List<Endereco> listar(){
        return service.listar();
    }

    @GetMapping(value = "/{id}")
    public ResponseEntity<Endereco> buscarId(@PathVariable Integer id){
        Endereco endereco = service.buscarPorId(id);
        return ResponseEntity.ok().body(endereco);
    }
}
