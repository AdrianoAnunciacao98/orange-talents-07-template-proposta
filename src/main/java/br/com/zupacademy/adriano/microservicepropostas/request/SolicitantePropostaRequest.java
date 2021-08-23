package br.com.zupacademy.adriano.microservicepropostas.request;

import br.com.zupacademy.adriano.microservicepropostas.model.SolicitanteProposta;
import br.com.zupacademy.adriano.microservicepropostas.validacao.CPFORCNPJ;

import javax.validation.constraints.*;
import java.math.BigDecimal;

public class SolicitantePropostaRequest {

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
    @PositiveOrZero
    private BigDecimal salario;

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

    public BigDecimal getSalario() {
        return salario;
    }

    public SolicitanteProposta toModel(){
        return new SolicitanteProposta(nome, salario, documento, endereco, email);
    }
}
