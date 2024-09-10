package com.acme.cerveja.controller;

import com.acme.cerveja.model.Avaliacao;
import com.acme.cerveja.model.Cerveja;
import com.acme.cerveja.payload.ResponsePayload;
import com.acme.cerveja.service.AvaliacaoService;
import com.acme.cerveja.service.CervejaService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/")
@RequiredArgsConstructor
@Slf4j
public class CervejaController {
    private final CervejaService cervejaService;
    private final AvaliacaoService avaliacaoService;
    @GetMapping
    public ResponseEntity<?> findAll() {
        return ResponseEntity.ok(cervejaService.findAll());
    }
    @GetMapping("/{id}")
    public ResponseEntity<?> findById(@PathVariable Long id) {
        log.info("Find Cerveja by ID {}", id);
        Optional<Cerveja> optCerveja = cervejaService.findById(id);
        if (optCerveja.isPresent()) {
            return ResponseEntity.ok(optCerveja.get());
        }else{
            return ResponseEntity.notFound().build();
        }
    }
    @GetMapping("/{id}/complete")
    public ResponseEntity<?> findByIdComAvaliacoes(@PathVariable Long id) {
        log.info("Find Cerveja by ID {}", id);

        Optional<Cerveja> optCerveja = cervejaService.findById(id);

        if (optCerveja.isPresent()) {
            List<Avaliacao> allById = avaliacaoService.getAllById(id);
            ResponsePayload responsePayload = new ResponsePayload(optCerveja.get(),allById);
            return ResponseEntity.ok(responsePayload);
        }else{
            return ResponseEntity.notFound().build();
        }
    }


    @DeleteMapping("/{id}")
    public ResponseEntity<?> delete(@PathVariable Long id) {
        cervejaService.deleteById(id);
        return ResponseEntity.ok().build();
    }
    @PostMapping
    public ResponseEntity<?> save(@RequestBody Cerveja cerveja) {
        Cerveja saved = cervejaService.create(cerveja);
        return ResponseEntity.ok(saved);
    }
    @PutMapping
    public ResponseEntity<?> update(@RequestBody Cerveja cerveja) {
        cervejaService.update(cerveja);
        return ResponseEntity.ok().build();
    }
}
