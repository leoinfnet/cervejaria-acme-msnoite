package com.acme.pedido.service;

import com.acme.pedido.model.Pedido;
import com.acme.pedido.repository.PedidoRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class PedidoService {
    private final PedidoRepository pedidoRepository;
    public Pedido salvar(Pedido pedido) {
        return pedidoRepository.save(pedido);
    }
}
