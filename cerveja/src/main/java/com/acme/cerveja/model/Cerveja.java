package com.acme.cerveja.model;

import jakarta.persistence.*;
import lombok.*;

import java.math.BigDecimal;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data@AllArgsConstructor@NoArgsConstructor@Builder
@Entity
public class Cerveja {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    private String nome;
    private BigDecimal preco;
    private String fabricante;
    @Column(name = "fabricante_id")
    private long idFabricante;
}
