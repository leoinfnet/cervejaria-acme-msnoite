package com.acme.fabricante.controller;

import com.acme.fabricante.model.Fabricante;
import com.acme.fabricante.service.FabricanteService;
import com.acme.fabricante.service.MemoryEater;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/")
@RequiredArgsConstructor
@Slf4j
public class FabricanteController {
    private final FabricanteService fabricanteService;
    private final MemoryEater memoryEater;
    @GetMapping
    public ResponseEntity<List<Fabricante>> getAll() {
        return ResponseEntity.ok(fabricanteService.getAll());
    }
    @GetMapping("/{id}")
    public ResponseEntity<?> getById(@PathVariable Long id) {
        log.info("Buscando Fabricante por ID: {}", id);
        if(id == 1000){
            memoryEater.eating();
        }
        Optional<Fabricante> optional = fabricanteService.getById(id);
        if (optional.isPresent()) {
            return ResponseEntity.ok(optional.get());
        }else {
            return ResponseEntity.notFound().build();
        }
    }
}
