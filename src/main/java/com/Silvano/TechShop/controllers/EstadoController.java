package com.Silvano.TechShop.controllers;

import com.Silvano.TechShop.entities.Estado;
import com.Silvano.TechShop.services.EstadoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/estados")
public class EstadoController {

    @Autowired
    private EstadoService service;

    @GetMapping("/all")
    public List<Estado> listar(){
        return service.listar();
    }

    @GetMapping(value = "/{id}")
    public ResponseEntity<Estado> buscarId(@PathVariable Integer id){
        Estado estado = service.buscarPorId(id);
        return ResponseEntity.ok().body(estado);
    }
}
