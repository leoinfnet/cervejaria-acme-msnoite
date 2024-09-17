package com.acme.pedido.controller;

import com.acme.pedido.model.ImpostoResponsePayload;
import com.acme.pedido.model.Pedido;
import com.acme.pedido.service.ImpostoService;
import com.acme.pedido.service.NotaFiscalService;
import com.acme.pedido.service.PedidoService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
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
@Slf4j
public class PedidoController {
    private final PedidoService pedidoService;
    private final ImpostoService impostoService;
    private final NotaFiscalService notaFiscalService;
    @PostMapping
    public ResponseEntity create(@RequestBody Pedido pedido) {
        log.info("Iniciando processo pedido: {}", pedido);
        BigDecimal totalImposto = impostoService.getTotalImposto(pedido).totalImposto();
        BigDecimal valorSemImposto = pedidoService.calcularValorTotal(pedido);
        pedido.setTotalImposto(totalImposto);
        pedido.setValorTotalSemImposto(valorSemImposto);
        pedido.setValorTotalComImposto(valorSemImposto.add(totalImposto));
        Pedido saved = pedidoService.salvar(pedido);
       // notaFiscalService.emitir(pedido.getId());
        return ResponseEntity.ok(Map.of("pedido", saved));

    }
}
