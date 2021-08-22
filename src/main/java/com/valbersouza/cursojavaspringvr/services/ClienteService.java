package com.valbersouza.cursojavaspringvr.services;

import com.valbersouza.cursojavaspringvr.domain.Cliente;
import com.valbersouza.cursojavaspringvr.repositories.ClienteRepository;
import com.valbersouza.cursojavaspringvr.services.exceptions.ObjectNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class ClienteService {

    @Autowired
    private ClienteRepository repo;

    public Cliente buscar(Integer id){
        Optional<Cliente> obj = repo.findById(id);
        return obj.orElseThrow(() -> new ObjectNotFoundException(
                "Objeto não encontrado! Id: " + id + " Tipo:  " + Cliente.class.getName()));
    }

}
