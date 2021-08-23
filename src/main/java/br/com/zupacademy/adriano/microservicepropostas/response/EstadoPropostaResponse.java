package br.com.zupacademy.adriano.microservicepropostas.response;

import br.com.zupacademy.adriano.microservicepropostas.enums.EstadoProposta;
import br.com.zupacademy.adriano.microservicepropostas.model.SolicitanteProposta;

import java.math.BigDecimal;

public class EstadoPropostaResponse {
    private EstadoProposta status;
    private String nome;
    private String documento;
    private String email;
    private String endereco;
    private BigDecimal salario;


    public EstadoPropostaResponse(SolicitanteProposta sp) {
        this.status = status;
        this.nome = sp.getNome();
        this.documento = sp.getDocumento();
        this.email = sp.getEmail();
        this.endereco = sp.getEndereco();
        this.salario = sp.getSalario();
    }

    public EstadoProposta getStatus() {
        return status;
    }

    public String getNome() {
        return nome;
    }

    public String getDocumento() {
        return documento;
    }

    public String getEmail() {
        return email;
    }

    public String getEndereco() {
        return endereco;
    }

    public BigDecimal getSalario() {
        return salario;
    }
}
