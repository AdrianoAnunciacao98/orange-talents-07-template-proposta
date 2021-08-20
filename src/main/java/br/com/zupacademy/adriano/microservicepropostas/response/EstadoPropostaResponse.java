package br.com.zupacademy.adriano.microservicepropostas.response;

import br.com.zupacademy.adriano.microservicepropostas.enums.EstadoProposta;
import br.com.zupacademy.adriano.microservicepropostas.model.SolicitanteProposta;

import java.math.BigDecimal;

public class EstadoPropostaResponse {
    private EstadoProposta status;
    private String nome;
    private String documento;
    private String email;
    private String endereco;
    private Double salario;


    public EstadoPropostaResponse(SolicitanteProposta proposta) {
        this.status = status;
        this.nome = proposta.getNome();
        this.documento = proposta.getDocumento();
        this.email = proposta.getEmail();
        this.endereco = proposta.getEndereco();
        this.salario = proposta.getSalario();
    }
}
