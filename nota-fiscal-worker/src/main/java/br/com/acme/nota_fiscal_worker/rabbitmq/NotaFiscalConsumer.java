package br.com.acme.nota_fiscal_worker.rabbitmq;

import br.com.acme.nota_fiscal_worker.model.NotaFiscal;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.messaging.handler.annotation.Payload;
import org.springframework.stereotype.Component;

@Slf4j
@Component
@RequiredArgsConstructor
public class NotaFiscalConsumer {
    private final ObjectMapper objectMapper = new ObjectMapper();
    private final NotaFiscalProducer producer;
    @RabbitListener(queues = {"nota-fiscal-queue"})
    public void receive(@Payload String message){
        try {
            NotaFiscal notaFiscal = objectMapper.readValue(message, NotaFiscal.class);
            log.info("Processando Nota Fiscal: {}", notaFiscal);
            Thread.sleep(3_000);
            producer.send(notaFiscal);
        } catch (JsonProcessingException e) {
            log.error("Erro ao decodificar a nota fiscal: {}", e.getMessage());
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }

        log.info("NotaFiscalConsumer received : {}", message);
    }
}
