package br.com.zupacademy.adriano.microservicepropostas.response;

import br.com.zupacademy.adriano.microservicepropostas.enums.EstadoAnalise;

public class ConsultaDadosResponse {

    private String nome;
    private String documento;
    private String idProposta;
    private EstadoAnalise resultadoSolicitacao;

    public String getNome() {
        return nome;
    }

    public String getDocumento() {
        return documento;
    }

    public String getIdProposta() {
        return idProposta;
    }

    public EstadoAnalise getResultadoSolicitacao() {
        return resultadoSolicitacao;
    }
}
