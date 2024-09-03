package com.acme.imposto.model;

import java.util.List;

public record PedidoPayload(List<ItemPedido> items) {
}
