package com.valbersouza.cursojavaspringvr.repositories;

import com.valbersouza.cursojavaspringvr.domain.Produto;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ProdutoRepository extends JpaRepository<Produto, Integer> {
}
