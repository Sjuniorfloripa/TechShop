package com.Silvano.TechShop.controllers;

import com.Silvano.TechShop.entities.Cliente;
import com.Silvano.TechShop.services.ClienteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/clientes")
public class ClienteController {


    @Autowired
    private ClienteService service;

    @GetMapping("/all")
    public List<Cliente> list(){
        return service.listar();
    }

    @GetMapping(value = "/{id}")
    public ResponseEntity<Cliente> buscarId(@PathVariable Integer id){
        Cliente cliente = service.buscarPorId(id);
        return ResponseEntity.ok().body(cliente);
    }
}
