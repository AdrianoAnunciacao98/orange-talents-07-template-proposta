package br.com.zupacademy.adriano.microservicepropostas.consultadados;

import br.com.zupacademy.adriano.microservicepropostas.model.SolicitanteProposta;

public class ConsultaDadosRequest {

    private String documento;
    private String nome;
    private String idSolicitacao;

    public ConsultaDadosRequest(){}

    public ConsultaDadosRequest(String documento, String nome, String idSolicitacao) {
        this.documento = documento;
        this.nome = nome;
        this.idSolicitacao = idSolicitacao;
    }

    public String getDocumento() {
        return documento;
    }

    public String getNome() {
        return nome;
    }

    public String getIdSolicitacao() {
        return idSolicitacao;
    }
}
