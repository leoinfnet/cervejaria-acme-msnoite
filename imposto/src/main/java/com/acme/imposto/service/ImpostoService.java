package com.acme.imposto.service;

import com.acme.imposto.model.*;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;

@Service
@RequiredArgsConstructor
public class ImpostoService {
    @Value("${usa}")
    private BigDecimal taxaUSA;
    @Value("${europa}")
    private BigDecimal taxaEuropa;
    @Value("${brasil}")
    private BigDecimal taxaBrasil;

    private final CervejaService cervejaService;
    private final FabricanteService fabricanteService;
    public BigDecimal calcularImpostoTotal(PedidoPayload pedidoPayload){
        return pedidoPayload.items().stream()
                .map(this::calcularImposto)
                .reduce(BigDecimal.ZERO, BigDecimal::add);
    }
    private BigDecimal calcularImposto(ItemPedido itemPedido){
        Cerveja cerveja = cervejaService.getById(itemPedido.getCervejaId());
        Fabricante fabricante = fabricanteService.getById(cerveja.getIdFabricante());
        BigDecimal taxa = getTaxas(fabricante.getPais());
        return  cerveja.getPreco()
                .multiply(taxa)
                .multiply(new BigDecimal(itemPedido.getQuantidade()));

    }

    private BigDecimal getTaxas(Pais pais){
        return switch (pais){
            case USA -> taxaUSA;
            case EUROPA -> taxaEuropa;
            case BRASIL -> taxaBrasil;
        };
    }
}
