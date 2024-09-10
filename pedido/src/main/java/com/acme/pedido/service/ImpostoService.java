package com.acme.pedido.service;

import com.acme.pedido.model.ImpostoResponsePayload;
import com.acme.pedido.model.Pedido;
import com.acme.pedido.service.clients.ImpostoClient;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestClient;

@Service
@RequiredArgsConstructor
public class ImpostoService {
    private final ImpostoClient impostoClient;

    public ImpostoResponsePayload getTotalImposto(Pedido pedido){
        return impostoClient.calcularImposto(pedido);
//        var serverUrl = "http://localhost:8084";
//        RestClient restClient = RestClient.create();
//        return restClient.post()
//                .uri(serverUrl)
//                .body(pedido)
//                .retrieve()
//                .toEntity(ImpostoResponsePayload.class).getBody();
    }
}
