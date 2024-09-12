package br.com.acme.nota_fiscal_worker.rabbitmq;

import br.com.acme.nota_fiscal_worker.model.NotaFiscal;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.amqp.core.AmqpTemplate;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class NotaFiscalProducer {
    private final AmqpTemplate amqpTemplate;
    private final ObjectMapper objectMapper = new ObjectMapper();
    public void send(NotaFiscal notaFiscal) throws JsonProcessingException {
        amqpTemplate.convertAndSend("nota-fiscal-ok.exc", "nota-fiscal-ok.rk",
                objectMapper.writeValueAsString(notaFiscal));
    }
}
