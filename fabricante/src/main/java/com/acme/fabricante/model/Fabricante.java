package com.acme.fabricante.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data@AllArgsConstructor@NoArgsConstructor@Builder
@Entity
public class Fabricante {
    @Id@GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    private String nome;
    private Pais pais;
}
