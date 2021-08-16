package br.com.zupacademy.adriano.microservicepropostas.request;

import br.com.zupacademy.adriano.microservicepropostas.model.Endereco;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

public class EnderecoRequest {

    @NotBlank
    private String logradouro;

    @NotNull
    private int numero;

    @NotBlank
    private String cep;


    private String complemento;

    @Deprecated
    public EnderecoRequest(){}

    public EnderecoRequest(String logradouro, int numero, String cep, String complemento) {
        this.logradouro = logradouro;
        this.numero = numero;
        this.cep = cep;
        this.complemento = complemento;
    }

    public Endereco toModel(){
        return new Endereco(logradouro, numero, cep, complemento);
    }
}
