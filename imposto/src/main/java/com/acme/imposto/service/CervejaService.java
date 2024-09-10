package com.acme.imposto.service;

import com.acme.imposto.model.Cerveja;
import com.acme.imposto.service.clients.CervejaClient;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestClient;

@Service
@RequiredArgsConstructor
public class CervejaService {
    private final CervejaClient cervejaClient;
    public Cerveja getById(Long id){
        return cervejaClient.getById(id);
//        RestClient restClient = RestClient.create();
//        var serverUrl = String.format("http://localhost:8081/%d", id);
//        return restClient.get()
//                .uri(serverUrl)
//                .retrieve()
//                .toEntity(Cerveja.class).getBody();
    }

}
