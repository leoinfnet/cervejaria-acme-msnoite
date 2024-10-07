package com.acme.imposto.service.clients;

import com.acme.imposto.model.Fabricante;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@FeignClient(name= "${services.fabricante}")
public interface FabricanteClient {
    @GetMapping("/{id}")
    Fabricante getById(@PathVariable("id") Long id);
}
