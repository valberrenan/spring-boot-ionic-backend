package com.valbersouza.cursojavaspringvr.services;

import com.valbersouza.cursojavaspringvr.domain.Categoria;
import com.valbersouza.cursojavaspringvr.domain.Pedido;
import com.valbersouza.cursojavaspringvr.repositories.PedidoRepository;
import com.valbersouza.cursojavaspringvr.services.exceptions.ObjectNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class PedidoService {

    @Autowired
    private PedidoRepository repo;

    public Pedido buscar(Integer id){
        Optional<Pedido> obj = repo.findById(id);
        return obj.orElseThrow(() -> new ObjectNotFoundException(
                "Objeto não encontrado! Id: " + id + " Tipo:  " + Pedido.class.getName()));
    }
}
