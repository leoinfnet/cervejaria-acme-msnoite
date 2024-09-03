package com.acme.cerveja.service;

import com.acme.cerveja.model.Cerveja;

import java.util.List;
import java.util.Optional;

public interface CervejaService {
    Cerveja create(Cerveja cerveja);
    Optional<Cerveja> findById(Long id);
    List<Cerveja> findAll();
    void deleteById(Long id);
    Cerveja update(Cerveja cerveja);

}
