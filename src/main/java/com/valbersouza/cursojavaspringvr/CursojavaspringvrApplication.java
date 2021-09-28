package com.valbersouza.cursojavaspringvr;

import com.valbersouza.cursojavaspringvr.domain.*;
import com.valbersouza.cursojavaspringvr.domain.enums.EstadoPagamento;
import com.valbersouza.cursojavaspringvr.domain.enums.TipoCliente;
import com.valbersouza.cursojavaspringvr.repositories.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.text.SimpleDateFormat;
import java.util.Arrays;

@SpringBootApplication
public class CursojavaspringvrApplication implements CommandLineRunner {

    public static void main(String[] args) {
        SpringApplication.run(CursojavaspringvrApplication.class, args);
    }

    @Override
    public void run(String... args) throws Exception {


    }
}
