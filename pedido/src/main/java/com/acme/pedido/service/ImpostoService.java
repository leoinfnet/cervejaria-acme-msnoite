package com.acme.pedido.service;

import com.acme.pedido.model.ImpostoResponsePayload;
import com.acme.pedido.model.Pedido;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestClient;

@Service
public class ImpostoService {
    public ImpostoResponsePayload getTotalImposto(Pedido pedido){
        var serverUrl = "http://localhost:8084";
        RestClient restClient = RestClient.create();
        return restClient.post()
                .uri(serverUrl)
                .body(pedido)
                .retrieve()
                .toEntity(ImpostoResponsePayload.class).getBody();
    }
}
