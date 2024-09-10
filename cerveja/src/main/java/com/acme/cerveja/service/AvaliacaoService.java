package com.acme.cerveja.service;

import com.acme.cerveja.model.Avaliacao;
import com.acme.cerveja.service.client.AvaliacaoClient;
import io.github.resilience4j.circuitbreaker.annotation.CircuitBreaker;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ConcurrentMap;

@Service
@RequiredArgsConstructor
@Slf4j
public class AvaliacaoService {
    private final AvaliacaoClient avaliacaoClient;
    private static Map<Long, List<Avaliacao>> CACHE = new ConcurrentHashMap<>();

    @CircuitBreaker(name = "avalicaoService", fallbackMethod = "buscarNoCache")
    public List<Avaliacao> getAllById(Long cervejaId){
        List<Avaliacao> avaliacoes = avaliacaoClient.getById(cervejaId);
        CACHE.put(cervejaId, avaliacoes);
        return avaliacaoClient.getById(cervejaId);
    }
    private List<Avaliacao> buscarNoCache(Long cervejaId, Throwable e){
      log.info("Buscando no Cache");
      return CACHE.getOrDefault(cervejaId,new ArrayList<>());
    }
}
