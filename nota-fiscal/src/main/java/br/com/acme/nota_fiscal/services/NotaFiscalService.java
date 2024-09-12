package br.com.acme.nota_fiscal.services;

import br.com.acme.nota_fiscal.model.NotaFiscal;
import br.com.acme.nota_fiscal.rabbitmq.NotaFiscalProducer;
import br.com.acme.nota_fiscal.repository.NotaFiscalRepository;
import com.fasterxml.jackson.core.JsonProcessingException;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class NotaFiscalService {
    private final NotaFiscalProducer notaFiscalProducer;
    private final NotaFiscalRepository notaFiscalRepository;
    public NotaFiscal emitir(NotaFiscal notaFiscal) throws JsonProcessingException {
        notaFiscalProducer.send(notaFiscal);
        return notaFiscalRepository.save(notaFiscal);
    }
    public List<NotaFiscal> findAll() {return notaFiscalRepository.findAll();}
    public NotaFiscal findById(Long id) {return notaFiscalRepository.findById(id).get();}

}
