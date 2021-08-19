package br.com.zupacademy.adriano.microservicepropostas.geracartao;

import br.com.zupacademy.adriano.microservicepropostas.model.SolicitanteProposta;

public class GerarCartaoRequest {
    private String documento;
    private String nome;
    private Long idProposta;


    public GerarCartaoRequest(SolicitanteProposta proposta) {
        this.documento = proposta.getDocumento();
        this.nome = proposta.getNome();
        this.idProposta = proposta.getId();
    }

    public String getDocumento() {
        return documento;
    }

    public String getNome() {
        return nome;
    }

    public Long getIdProposta() {
        return idProposta;
    }


}
