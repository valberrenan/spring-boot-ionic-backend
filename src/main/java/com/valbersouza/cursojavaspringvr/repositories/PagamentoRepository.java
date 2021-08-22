package com.valbersouza.cursojavaspringvr.repositories;

import com.valbersouza.cursojavaspringvr.domain.Pagamento;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PagamentoRepository extends JpaRepository<Pagamento, Integer> {
}
