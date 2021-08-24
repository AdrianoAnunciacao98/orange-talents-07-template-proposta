package br.com.zupacademy.adriano.microservicepropostas.request;

import javax.validation.constraints.NotBlank;

public class BloqueiaCartaoRequest {

    @NotBlank
    private String sistemaBloqueio;

    public BloqueiaCartaoRequest(String sistemaBloqueio) {
        this.sistemaBloqueio = sistemaBloqueio;
    }

    public String getSistemaBloqueio() {
        return sistemaBloqueio;
    }

    public BloqueiaCartaoRequest(){}
}
