package com.valbersouza.cursojavaspringvr.repositories;

import com.valbersouza.cursojavaspringvr.domain.Cidade;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CidadeRepository extends JpaRepository<Cidade, Integer> {
}
