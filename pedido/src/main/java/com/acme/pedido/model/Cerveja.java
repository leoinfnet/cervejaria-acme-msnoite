package com.acme.pedido.model;


import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class Cerveja {
    private int id;
    private String nome;
    private BigDecimal preco;
    private String fabricante;
    private int fabricanteId;
}
