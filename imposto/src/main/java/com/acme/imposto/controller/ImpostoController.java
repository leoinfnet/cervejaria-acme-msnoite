package com.acme.imposto.controller;

import com.acme.imposto.model.PedidoPayload;
import com.acme.imposto.service.ImpostoService;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.math.BigDecimal;
import java.util.Map;

@RestController@RequestMapping("/")
@RequiredArgsConstructor
public class ImpostoController {
    private final ImpostoService impostoService;
    @PostMapping
    public ResponseEntity calcularImposto(@RequestBody PedidoPayload pedidoPayload){
        BigDecimal impostoTotal = impostoService.calcularImpostoTotal(pedidoPayload);
        return ResponseEntity.ok(Map.of("totalImposto", impostoTotal));
    }
}
