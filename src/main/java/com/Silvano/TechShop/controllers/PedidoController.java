package com.Silvano.TechShop.controllers;

import com.Silvano.TechShop.entities.Pedido;
import com.Silvano.TechShop.services.PedidoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/pedidos")
public class PedidoController {

    @Autowired
    private PedidoService service;

    @PostMapping
    public Pedido criar(@RequestBody Pedido pedido){
        return service.criar(pedido);
    }

    @GetMapping("/all")
    public List<Pedido> listar(){
        return service.listar();
    }

    @GetMapping(value = "/{id}")
    public ResponseEntity<Pedido> buscarId(@PathVariable Integer id){
        Pedido pedido = service.buscarPorId(id);
        return ResponseEntity.ok().body(pedido);
    }
}
