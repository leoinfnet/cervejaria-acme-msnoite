package com.acme.pedido.controller;

import com.acme.pedido.model.ImpostoResponsePayload;
import com.acme.pedido.model.Pedido;
import com.acme.pedido.service.ImpostoService;
import com.acme.pedido.service.PedidoService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.math.BigDecimal;
import java.util.Map;

@RestController
@RequestMapping("/")
@RequiredArgsConstructor
public class PedidoController {
    private final PedidoService pedidoService;
    private final ImpostoService impostoService;
    @PostMapping
    public ResponseEntity create(@RequestBody Pedido pedido) {
        //TODO Calcular O Imposto do Pedido
        BigDecimal totalImposto = impostoService.getTotalImposto(pedido).totalImposto();
        BigDecimal valorSemImposto = pedidoService.calcularValorTotal(pedido);
        pedido.setTotalImposto(totalImposto);
        pedido.setValorTotalSemImposto(valorSemImposto);
        pedido.setValorTotalComImposto(valorSemImposto.add(totalImposto));
        Pedido saved = pedidoService.salvar(pedido);
        return ResponseEntity.ok(Map.of("pedido", saved));

    }
}
