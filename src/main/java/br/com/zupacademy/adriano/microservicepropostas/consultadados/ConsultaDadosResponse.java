package br.com.zupacademy.adriano.microservicepropostas.consultadados;

public class ConsultaDadosResponse {

    private String nome;
    private String documento;
    private Long idSolicitacao;
    private String resultadoConsulta;

    public ConsultaDadosResponse(){}

    public ConsultaDadosResponse(String nome, String documento, Long idSolicitacao, String resultadoConsulta) {
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

    public Long getIdSolicitacao() {
        return idSolicitacao;
    }

    public String getResultadoConsulta() {
        return resultadoConsulta;
    }
}
