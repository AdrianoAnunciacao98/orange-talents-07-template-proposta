package br.com.zupacademy.adriano.microservicepropostas.geracartao;

import java.time.LocalDateTime;

public class VencimentoResponse {

    private String id;
    private int dia;
    private LocalDateTime dataDeCriacao;

    public VencimentoResponse(String id, int dia, LocalDateTime dataDeCriacao) {
        this.id = id;
        this.dia = dia;
        this.dataDeCriacao = dataDeCriacao;
    }

    public String getId() {
        return id;
    }

    public int getDia() {
        return dia;
    }

    public LocalDateTime getDataDeCriacao() {
        return dataDeCriacao;
    }
}
