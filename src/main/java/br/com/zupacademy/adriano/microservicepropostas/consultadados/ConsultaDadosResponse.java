package br.com.zupacademy.adriano.microservicepropostas.consultadados;

import br.com.zupacademy.adriano.microservicepropostas.enums.EstadoAnalise;

public class ConsultaDadosResponse {

    private String nome;
    private String documento;
    private String idSolicitacao;
    private EstadoAnalise resultadoConsulta;

    public ConsultaDadosResponse(){}

    public ConsultaDadosResponse(String nome, String documento, String idSolicitacao, EstadoAnalise resultadoConsulta) {
        this.nome = nome;
        this.documento = documento;
        this.idSolicitacao = idSolicitacao;
        this.resultadoConsulta = resultadoConsulta;
    }

    public String getNome() {
        return nome;
    }

    public String getDocumento() {
        return documento;
    }

    public String getIdSolicitacao() {
        return idSolicitacao;
    }

    public EstadoAnalise getResultadoConsulta() {
        return resultadoConsulta;
    }
}
