package br.com.zupacademy.adriano.microservicepropostas.config;

import com.fasterxml.jackson.annotation.JsonProperty;

public class ResultadoResponse {
    private String resultado;

    public ResultadoResponse(@JsonProperty("resultado") String resultado) {
        this.resultado = resultado;
    }

    public String getResultado() {
        return resultado;
    }
}
