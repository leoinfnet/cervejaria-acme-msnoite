package com.acme.pedido.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.math.BigDecimal;
import java.util.List;

@Data@AllArgsConstructor@NoArgsConstructor@Builder
@Document(collection = "pedidos")
public class Pedido {
    @Id
    private String id;
    private List<ItemPedido> items;
    private BigDecimal totalImposto;
}
