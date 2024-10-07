package com.acme.avaliacao.controller;

import com.acme.avaliacao.model.Avaliacao;
import com.acme.avaliacao.service.AvaliacaoService;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.context.annotation.Role;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/")
@Slf4j@RequiredArgsConstructor
public class AvaliacaoController {
    private final AvaliacaoService avalicaoService;
    @GetMapping("/{id}")
    public ResponseEntity<?> getAvaliacao(@PathVariable Long id) {
        log.info("Get avaliacao: {}", id);
        List<Avaliacao> allByCervejaId = avalicaoService.getAllByCervejaId(id);
        if (allByCervejaId.isEmpty()) {
            return ResponseEntity.notFound().build();
        }else {
            return ResponseEntity.ok(allByCervejaId);
        }
    }

}
