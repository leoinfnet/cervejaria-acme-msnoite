package com.acme.fabricante.controller;

import com.acme.fabricante.model.Fabricante;
import com.acme.fabricante.service.FabricanteService;
import lombok.RequiredArgsConstructor;
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
public class FabricanteController {
    private final FabricanteService fabricanteService;
    @GetMapping
    public ResponseEntity<List<Fabricante>> getAll() {
        return ResponseEntity.ok(fabricanteService.getAll());
    }
    @GetMapping("/{id}")
    public ResponseEntity<?> getById(@PathVariable Long id) {
        Optional<Fabricante> optional = fabricanteService.getById(id);
        if (optional.isPresent()) {
            return ResponseEntity.ok(optional.get());
        }else {
            return ResponseEntity.notFound().build();
        }
    }
}
