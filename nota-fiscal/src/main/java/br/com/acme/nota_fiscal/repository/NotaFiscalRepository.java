package br.com.acme.nota_fiscal.repository;

import br.com.acme.nota_fiscal.model.NotaFiscal;
import org.springframework.data.jpa.repository.JpaRepository;

public interface NotaFiscalRepository extends JpaRepository<NotaFiscal, Long> {
}
