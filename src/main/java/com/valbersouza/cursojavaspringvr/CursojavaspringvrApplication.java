package com.valbersouza.cursojavaspringvr;

import com.valbersouza.cursojavaspringvr.domain.Categoria;
import com.valbersouza.cursojavaspringvr.repositories.CategoriaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.Arrays;

@SpringBootApplication
public class CursojavaspringvrApplication implements CommandLineRunner {

    @Autowired
    private CategoriaRepository categoriaRepository;

    public static void main(String[] args) {
        SpringApplication.run(CursojavaspringvrApplication.class, args);
    }

    @Override
    public void run(String... args) throws Exception {

        Categoria cat1 = new Categoria(null, "Informática");
        Categoria cat2 = new Categoria(null, "Escritorio");

        categoriaRepository.saveAll(Arrays.asList(cat1, cat2));
    }
}
