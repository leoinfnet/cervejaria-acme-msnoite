package com.acme.pedido.repository;

import com.acme.pedido.model.Pedido;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface PedidoRepository extends MongoRepository<Pedido, String> {
}
