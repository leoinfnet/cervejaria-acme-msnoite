package com.acme.cerveja.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data @AllArgsConstructor @NoArgsConstructor @Builder
public class Avaliacao {
    private long id;
    private long cevejaId;
    private String avaliacao;
}
