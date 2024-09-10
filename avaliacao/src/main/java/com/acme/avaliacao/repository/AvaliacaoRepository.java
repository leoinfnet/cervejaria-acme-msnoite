package com.acme.avaliacao.repository;

import com.acme.avaliacao.model.Avaliacao;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface AvaliacaoRepository extends JpaRepository<Avaliacao, Long> {
    List<Avaliacao> findAllByCevejaId(Long cervejaId) ;
}
