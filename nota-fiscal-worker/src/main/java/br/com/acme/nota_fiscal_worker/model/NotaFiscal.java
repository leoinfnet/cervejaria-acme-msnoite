package br.com.acme.nota_fiscal_worker.model;
import lombok.*;

@Data@AllArgsConstructor@NoArgsConstructor@Builder@ToString
public class NotaFiscal {
    private Long id;
    private String pedidoId;
}
