package com.Silvano.TechShop.controllers;

import com.Silvano.TechShop.dto.ClienteDto;
import com.Silvano.TechShop.entities.Cliente;
import com.Silvano.TechShop.services.ClienteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import javax.validation.Valid;
import java.net.URI;
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

    @PostMapping
    public ResponseEntity<Void> inserir(@Valid @RequestBody ClienteDto clienteDto){
        Cliente cliente = service.fromDto(clienteDto);
        cliente = service.criar(cliente);
        URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}")
                .buildAndExpand(cliente.getId()).toUri();
        return ResponseEntity.created(uri).build();
    }

    @PutMapping(value = "/{id}")
    public ResponseEntity<Void> update(@Valid @RequestBody ClienteDto clienteDto, @PathVariable Integer id){
        Cliente cliente = service.fromDto(clienteDto);
        cliente.setId(id);
        cliente = service.update(cliente);
        return ResponseEntity.noContent().build();
    }

    @DeleteMapping(value = "/{id}")
    public ResponseEntity<Void> delete(@PathVariable Integer id){
        service.delete(id);
        return ResponseEntity.noContent().build();
    }

    @GetMapping(value = "/page")
    public ResponseEntity<Page<ClienteDto>> findPage(

            @RequestParam(value = "page", defaultValue = "0") Integer page,
            @RequestParam(value = "linesPerPage", defaultValue = "24") Integer linesPerPage,
            @RequestParam(value = "orderBy", defaultValue = "nome") String orderBy,
            @RequestParam(value = "direction", defaultValue = "ASC") String direction){

        Page<Cliente> list = service.encontrarPagina(page, linesPerPage, orderBy, direction);
        Page<ClienteDto> listDto = list.map(cliente -> new ClienteDto(cliente));
        return ResponseEntity.ok().body(listDto);
    }
}
