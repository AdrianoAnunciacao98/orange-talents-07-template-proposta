package br.com.zupacademy.adriano.microservicepropostas.request;

import br.com.zupacademy.adriano.microservicepropostas.enums.EstadoAnalise;
import br.com.zupacademy.adriano.microservicepropostas.model.Endereco;
import br.com.zupacademy.adriano.microservicepropostas.model.SolicitanteProposta;
import br.com.zupacademy.adriano.microservicepropostas.validacao.CPFORCNPJ;
import br.com.zupacademy.adriano.microservicepropostas.validacao.UniqueValue;

import javax.persistence.Embedded;
import javax.persistence.Enumerated;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Positive;

public class SolicitantePropostaRequest {

    @NotBlank
    private String nome;

    @CPFORCNPJ
    @NotBlank
    @UniqueValue(domainClass = SolicitanteProposta.class, fieldName = "documento", message = "Não pode repetir a solicitação")
    private String documento;

    @NotBlank
    @Email
    private String email;

    @NotNull
    @Embedded
    private Endereco endereco;

    @NotNull
    @Positive
    private double salario;

    @Enumerated
    private EstadoAnalise analise;

    public SolicitanteProposta toModel(){
        return new SolicitanteProposta(nome, salario, documento, endereco, email, analise);
    }

    public String getNome() {
        return nome;
    }

    public String getDocumento() {
        return documento;
    }

    public String getEmail() {
        return email;
    }

    public Endereco getEndereco() {
        return endereco;
    }

    public double getSalario() {
        return salario;
    }

    public EstadoAnalise getAnalise() {
        return analise;
    }
}
