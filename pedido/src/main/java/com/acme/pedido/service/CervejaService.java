package com.acme.pedido.service;

import com.acme.pedido.model.Cerveja;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestClient;

@Service
@RequiredArgsConstructor
public class CervejaService {
    public Cerveja getById(Long id){
        var serverUrl = String.format("http://localhost:8081/%d", id);
        RestClient restClient = RestClient.create();
        return restClient
                .get()
                .uri(serverUrl)
                .retrieve()
                .toEntity(Cerveja.class).getBody();
    }
}
