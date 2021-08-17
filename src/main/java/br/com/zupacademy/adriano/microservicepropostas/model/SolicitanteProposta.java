package br.com.zupacademy.adriano.microservicepropostas.model;

import br.com.zupacademy.adriano.microservicepropostas.enums.EstadoAnalise;
import br.com.zupacademy.adriano.microservicepropostas.request.EnderecoRequest;
import br.com.zupacademy.adriano.microservicepropostas.request.SolicitantePropostaRequest;

import javax.persistence.*;

@Entity
public class SolicitanteProposta {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private String nome;

    @Column(nullable = false)
    private double salario;

    @Column(nullable = false)
    private String documento;

    @Embedded
    private Endereco endereco;

    @Column(nullable = false)
    private String email;

    @Enumerated
    private EstadoAnalise analise;


    public SolicitanteProposta(String nome, double salario, String documento, Endereco endereco, String email, EstadoAnalise analise) {
        this.nome = nome;
        this.salario = salario;
        this.documento = documento;
        this.endereco = endereco;
        this.email = email;
        this.analise = analise;
    }

    public SolicitanteProposta(SolicitantePropostaRequest req, EnderecoRequest endRequest) {
        this.nome = req.getNome();
        this.salario = req.getSalario();
        this.documento = req.getDocumento();
        this.endereco = endRequest.toModel();
        this.email = req.getEmail();
        this.analise = EstadoAnalise.NAO_ELEGIVEL;
    }


    public Long getId() {
        return id;
    }

    public void setAnalise(EstadoAnalise analise) {
        this.analise = analise;
    }

    public String getNome() {
        return nome;
    }

    public String getDocumento() {
        return documento;
    }
}
