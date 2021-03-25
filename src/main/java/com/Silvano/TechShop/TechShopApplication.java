package com.Silvano.TechShop;

import com.Silvano.TechShop.entities.Categoria;
import com.Silvano.TechShop.entities.Cidade;
import com.Silvano.TechShop.entities.Estado;
import com.Silvano.TechShop.entities.Produto;
import com.Silvano.TechShop.repositories.CategoriaRepository;
import com.Silvano.TechShop.repositories.CidadeRepository;
import com.Silvano.TechShop.repositories.EstadoRepository;
import com.Silvano.TechShop.repositories.ProdutoRepository;
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
    @Autowired
    private ProdutoRepository produtoRepository;
    @Autowired
    private CidadeRepository cidadeRepository;
    @Autowired
    private EstadoRepository estadoRepository;

    @Override
    public void run(String... args) throws Exception {

        //inserir categorias
        Categoria categoria1 = new Categoria(null, "Informática");
        Categoria categoria2 = new Categoria(null, "Escritório");

        //inserir produtos
        Produto produto1 = new Produto(null, "Computador", 2000.0);
        Produto produto2 = new Produto(null, "Impressora", 800.0);
        Produto produto3 = new Produto(null, "Mouse", 80.0);

        //Estado
        Estado estado1 = new Estado(null, "Santa Catarina");
        Estado estado2 = new Estado(null, "São Paulo");

        //Cidades
        Cidade cidade1 = new Cidade(null, "Florianópolis", estado1);
        Cidade cidade2 = new Cidade(null, "São Paulo", estado2);
        Cidade cidade3 = new Cidade(null, "Campinas", estado2);
        Cidade cidade4 = new Cidade(null, "Biguaçu", estado1);

        //inserir relacionamentos no Banco de dados:

        //categorias
        categoria1.getProdutos().addAll(Arrays.asList(produto1, produto2, produto3));
        categoria2.getProdutos().addAll(Arrays.asList(produto2));

        //produtos
        produto1.getCategorias().addAll(Arrays.asList(categoria1));
        produto2.getCategorias().addAll(Arrays.asList(categoria1, categoria2));
        produto3.getCategorias().addAll(Arrays.asList(categoria1));

        //estados
        estado1.getCidades().addAll(Arrays.asList(cidade1, cidade4));
        estado2.getCidades().addAll(Arrays.asList(cidade2, cidade3));

        //ação dos repositories
        categoriaRepository.saveAll(Arrays.asList(categoria1, categoria2));
        produtoRepository.saveAll(Arrays.asList(produto1, produto2, produto3));
        estadoRepository.saveAll(Arrays.asList(estado1, estado2));
        cidadeRepository.saveAll(Arrays.asList(cidade1, cidade2, cidade3, cidade4));
    }
}
