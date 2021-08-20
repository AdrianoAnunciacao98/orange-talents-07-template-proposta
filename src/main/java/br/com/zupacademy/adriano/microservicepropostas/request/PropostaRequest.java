package br.com.zupacademy.adriano.microservicepropostas.request;

import br.com.zupacademy.adriano.microservicepropostas.model.SolicitanteProposta;
import br.com.zupacademy.adriano.microservicepropostas.validacao.CPFORCNPJ;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Positive;

public class PropostaRequest {

    @NotBlank
    @CPFORCNPJ
    private String documento;

    @NotBlank
    @Email
    private String email;

    @NotBlank
    private String nome;

    @NotBlank
    private String endereco;

    @NotNull
    @Positive
    private Double salario;

    public SolicitanteProposta toModel() {
        return new SolicitanteProposta(nome, salario, documento, endereco, email);
    }

    public String getDocumento() {
        return documento;
    }

    public String getEmail() {
        return email;
    }

    public String getNome() {
        return nome;
    }

    public String getEndereco() {
        return endereco;
    }

    public Double getSalario() {
        return salario;
    }
}
