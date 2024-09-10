package com.acme.imposto.service;

import com.acme.imposto.model.Fabricante;
import com.acme.imposto.service.clients.FabricanteClient;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestClient;

@Service
@RequiredArgsConstructor
public class FabricanteService {
    private final FabricanteClient fabricanteClient;
    public Fabricante getById(Long id) {
        return fabricanteClient.getById(id);
//        var serverUrl = String.format("http://localhost:8082/%d", id);
//        RestClient restClient = RestClient.create();
//        return restClient
//                .get()
//                .uri(serverUrl)
//                .retrieve()
//                .toEntity(Fabricante.class).getBody();
    }
}
