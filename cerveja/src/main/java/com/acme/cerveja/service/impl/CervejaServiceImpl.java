package com.acme.cerveja.service.impl;

import com.acme.cerveja.model.Cerveja;
import com.acme.cerveja.repository.CervejaRepository;
import com.acme.cerveja.service.CervejaService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;
import java.util.Optional;
@Service
@RequiredArgsConstructor
public class CervejaServiceImpl implements CervejaService {
    private final CervejaRepository cervejaRepository;

    @Override
    public Cerveja create(Cerveja cerveja) {
        return cervejaRepository.save(cerveja);
    }

    @Override
    public Optional<Cerveja> findById(Long id) {
        return cervejaRepository.findById(id);
    }

    @Override
    public List<Cerveja> findAll() {
        return cervejaRepository.findAll();
    }

    @Override
    public void deleteById(Long id) {
        cervejaRepository.deleteById(id);
    }

    @Override
    public Cerveja update(Cerveja cerveja) {
        return cervejaRepository.save(cerveja);
    }
}
