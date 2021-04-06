package com.Silvano.TechShop.services;

import com.Silvano.TechShop.dto.ClienteDto;
import com.Silvano.TechShop.entities.Cliente;
import com.Silvano.TechShop.exceptions.DataIntegrityException;
import com.Silvano.TechShop.exceptions.ObjectNotFoundException;
import com.Silvano.TechShop.repositories.ClienteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ClienteService {

    @Autowired
    private ClienteRepository repository;

    public List<Cliente> listar() {
        return repository.findAll();
    }

    public Cliente buscarPorId(Integer id) {
        return repository.findById(id).orElseThrow(() -> new ObjectNotFoundException(
                String.format("Cliente não encontrado! ID: %d, Tipo: %s.", id, Cliente.class.getName())
        ));
    }

    public Cliente criar(Cliente cliente) {
        cliente.setId(null);
        return repository.save(cliente);
    }

    public Cliente update(Cliente cliente) {
        Cliente newObj = buscarPorId(cliente.getId());
        updateData(newObj, cliente);
        return repository.save(cliente);
    }

    public void delete(Integer id) {
        buscarPorId(id);
        try {
            repository.deleteById(id);
        } catch (DataIntegrityException e){
            throw new DataIntegrityException(
                    "Não é possível excluir clientes com pedidos salvos dentro da table!"
            );
        }
    }

    public Page<Cliente> encontrarPagina(Integer page, Integer linesPerPage, String orderBy, String direction){
        PageRequest pageRequest = PageRequest.of(page, linesPerPage, Sort.Direction.valueOf(direction), orderBy);
        return repository.findAll(pageRequest);
    }

    public Cliente fromDto(ClienteDto clienteDto){
        return new Cliente(clienteDto.getId(),clienteDto.getNome(), clienteDto.getEmail(), null, null);
    }

    private void updateData(Cliente newObj, Cliente cliente){
        newObj.setNome(cliente.getNome());
        newObj.setEmail(cliente.getEmail());
    }
}
