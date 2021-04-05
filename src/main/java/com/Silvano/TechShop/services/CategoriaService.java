package com.Silvano.TechShop.services;

import com.Silvano.TechShop.dto.CategoriaDto;
import com.Silvano.TechShop.entities.Categoria;
import com.Silvano.TechShop.exceptions.DataIntegrityException;
import com.Silvano.TechShop.exceptions.ObjectNotFoundException;
import com.Silvano.TechShop.repositories.CategoriaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CategoriaService {

    @Autowired
    private CategoriaRepository repository;

    public Categoria criar(Categoria categoria) {
        categoria.setId(null);
        return repository.save(categoria);
    }

    public List<Categoria> listar() {
        return repository.findAll();
    }

    public Categoria buscarPorId(Integer id) {
        return repository.findById(id).orElseThrow(() -> new ObjectNotFoundException(
                String.format("Categoria não encontrada! ID: %d Tipo: %s", id, Categoria.class.getName())
        ));
    }

    public Categoria update(Categoria categoria) {
        buscarPorId(categoria.getId());
        return repository.save(categoria);
    }

    public void delete(Integer id) {
        buscarPorId(id);
        try {
            repository.deleteById(id);
        } catch (DataIntegrityViolationException e) {
            throw new DataIntegrityException(
                    "Não é possível excluir categoria que possui produtos dentro da table.");
        }
    }

    public Page<Categoria> encontrarPagina(Integer page, Integer linesPerPage, String orderBy, String direction) {
        PageRequest pageRequest = PageRequest.of( page, linesPerPage, Sort.Direction.valueOf(direction), orderBy);
        return repository.findAll(pageRequest);
    }

    public Categoria fromDto(CategoriaDto categoriaDto){
        return new Categoria(categoriaDto.getId(), categoriaDto.getNome());
    }
}
