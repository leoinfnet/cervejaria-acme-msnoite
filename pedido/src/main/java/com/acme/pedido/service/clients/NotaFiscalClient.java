package com.acme.pedido.service.clients;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@FeignClient("NOTA-FISCAL-SERVICE")
public interface NotaFiscalClient {
    @GetMapping("/emitir/{pedidoId}")
    void emitir(@PathVariable("pedidoId") String pedidoId);
}
