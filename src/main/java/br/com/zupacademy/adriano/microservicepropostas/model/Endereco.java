package br.com.zupacademy.adriano.microservicepropostas.model;

import javax.persistence.Embeddable;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Positive;

@Embeddable
public class Endereco {

    @NotBlank
    private String logradouro;

    @NotNull
    @Positive
    private int numero;

    @NotBlank
    private String cep;


    private String complemento;


    public Endereco(String logradouro, int numero, String cep, String complemento) {
        this.logradouro = logradouro;
        this.numero = numero;
        this.cep = cep;
        this.complemento = complemento;
    }

    @Deprecated
    public Endereco(){}
}
