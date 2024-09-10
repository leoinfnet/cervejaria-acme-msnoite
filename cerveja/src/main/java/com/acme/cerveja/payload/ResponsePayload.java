package com.acme.cerveja.payload;

import com.acme.cerveja.model.Avaliacao;
import com.acme.cerveja.model.Cerveja;

import java.util.List;

public record ResponsePayload(Cerveja cerveja, List<Avaliacao> avaliacoes) {
}
