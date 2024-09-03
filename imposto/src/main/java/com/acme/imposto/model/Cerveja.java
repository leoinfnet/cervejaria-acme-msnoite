package com.acme.imposto.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;

@Data@AllArgsConstructor@NoArgsConstructor@Builder
public class Cerveja {
    private long id;
    private String nome;
    private BigDecimal preco;
    private String fabricante;
    private long idFabricante;
}
