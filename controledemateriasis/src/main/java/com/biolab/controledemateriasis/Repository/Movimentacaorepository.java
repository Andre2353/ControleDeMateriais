package com.biolab.controledemateriasis.Repository;

import com.biolab.controledemateriasis.entities.Movimentacao;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface Movimentacaorepository extends JpaRepository<Movimentacao, Long> {
}
