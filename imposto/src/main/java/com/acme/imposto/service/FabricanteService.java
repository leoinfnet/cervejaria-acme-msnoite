package com.acme.imposto.service;

import com.acme.imposto.model.Fabricante;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestClient;

@Service
public class FabricanteService {
    public Fabricante getById(Long id) {
        var serverUrl = String.format("http://localhost:8082/%d", id);
        RestClient restClient = RestClient.create();
        return restClient
                .get()
                .uri(serverUrl)
                .retrieve()
                .toEntity(Fabricante.class).getBody();
    }
}
