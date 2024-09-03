package com.acme.imposto.service;

import com.acme.imposto.model.Cerveja;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestClient;

@Service
public class CervejaService {
    public Cerveja getById(Long id){
        RestClient restClient = RestClient.create();
        var serverUrl = String.format("http://localhost:8081/%d", id);
        return restClient.get()
                .uri(serverUrl)
                .retrieve()
                .toEntity(Cerveja.class).getBody();
    }

}
