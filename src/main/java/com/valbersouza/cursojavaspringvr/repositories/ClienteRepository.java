package com.valbersouza.cursojavaspringvr.repositories;

import com.valbersouza.cursojavaspringvr.domain.Cliente;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ClienteRepository extends JpaRepository<Cliente, Integer> {
}
