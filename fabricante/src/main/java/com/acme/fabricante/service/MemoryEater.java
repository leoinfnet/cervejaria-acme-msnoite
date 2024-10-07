package com.acme.fabricante.service;

import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
@Slf4j
public class MemoryEater {
    List<Object> memoryList = new ArrayList<>();
    public void eating(){
        log.info("Eating");
        var memory = 0L;
        while(true){
            memoryList.add(new byte[1_000_000]);
            memory+=1_000_000;
            if(memory % 100_000_000 == 0){
                log.info("Memória consumida: " + memoryList.size() + " MB");
            }

        }

    }
}
