package br.com.zupacademy.adriano.microservicepropostas.consultadados;

import br.com.zupacademy.adriano.microservicepropostas.model.SolicitanteProposta;

public class ConsultaDadosRequest {

    private String documento;
    private String nome;
    private Long idSolicitacao;

    public ConsultaDadosRequest(){}

    public ConsultaDadosRequest(SolicitanteProposta solicProposta) {
        this.documento = solicProposta.getDocumento();
        this.nome = solicProposta.getNome();
        this.idSolicitacao = solicProposta.getId();
    }

    public String getDocumento() {
        return documento;
    }

    public String getNome() {
        return nome;
    }

    public Long getIdSolicitacao() {
        return idSolicitacao;
    }
}
