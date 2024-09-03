package com.acme.cerveja.controller;

import com.acme.cerveja.model.Cerveja;
import com.acme.cerveja.service.CervejaService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
@RequestMapping("/")
@RequiredArgsConstructor
public class CervejaController {
    private final CervejaService cervejaService;
    @GetMapping
    public ResponseEntity<?> findAll() {
        return ResponseEntity.ok(cervejaService.findAll());
    }
    @GetMapping("/{id}")
    public ResponseEntity<?> findById(@PathVariable Long id) {
        Optional<Cerveja> optCerveja = cervejaService.findById(id);
        if (optCerveja.isPresent()) {
            return ResponseEntity.ok(optCerveja.get());
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
