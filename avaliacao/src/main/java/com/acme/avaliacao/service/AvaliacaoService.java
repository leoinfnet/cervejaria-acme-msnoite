package com.acme.avaliacao.service;

import com.acme.avaliacao.model.Avaliacao;
import com.acme.avaliacao.repository.AvaliacaoRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class AvaliacaoService {
    private final AvaliacaoRepository avaliacaoRepository;
    public List<Avaliacao> getAllByCervejaId(Long cevejaId){
        return avaliacaoRepository.findAllByCevejaId(cevejaId);
    }
}
