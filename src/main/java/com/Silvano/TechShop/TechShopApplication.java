package com.Silvano.TechShop;

import com.Silvano.TechShop.entities.Categoria;
import com.Silvano.TechShop.repositories.CategoriaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.Arrays;

@SpringBootApplication
public class TechShopApplication implements CommandLineRunner {

    public static void main(String[] args) {
        SpringApplication.run(TechShopApplication.class, args);
    }

    @Autowired
    private CategoriaRepository categoriaRepository;

    @Override
    public void run(String... args) throws Exception {

        //inserir categorias
        Categoria categoria1 = new Categoria(null, "Informática");
        Categoria categoria2 = new Categoria(null, "Escritório");

        categoriaRepository.saveAll(Arrays.asList(categoria1, categoria2));
    }
}
