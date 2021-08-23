package br.com.zupacademy.adriano.microservicepropostas.consultadados;

import br.com.zupacademy.adriano.microservicepropostas.model.SolicitanteProposta;

public class ConsultaDadosRequest {

    private String documento;
    private String nome;
    private String idProposta;

    public ConsultaDadosRequest(){}

    public ConsultaDadosRequest(String documento, String nome, String idProposta) {
        this.documento = documento;
        this.nome = nome;
        this.idProposta = idProposta;
    }

    public String getDocumento() {
        return documento;
    }

    public String getNome() {
        return nome;
    }

    public String getIdProposta() {
        return idProposta;
    }
}
