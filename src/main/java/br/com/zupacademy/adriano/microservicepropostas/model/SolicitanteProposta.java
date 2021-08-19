package br.com.zupacademy.adriano.microservicepropostas.model;

import br.com.zupacademy.adriano.microservicepropostas.enums.EstadoAnalise;
import br.com.zupacademy.adriano.microservicepropostas.enums.EstadoProposta;
import br.com.zupacademy.adriano.microservicepropostas.request.EnderecoRequest;
import br.com.zupacademy.adriano.microservicepropostas.request.SolicitantePropostaRequest;

import javax.persistence.*;
import javax.validation.constraints.Size;

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

    @Enumerated(EnumType.STRING)
    private EstadoProposta analise;

    private String numeroCartao;


    public SolicitanteProposta(String nome, double salario, String documento, Endereco endereco, String email) {
        this.nome = nome;
        this.salario = salario;
        this.documento = documento;
        this.endereco = endereco;
        this.email = email;
        this.analise = EstadoProposta.NAO_ELEGIVEL;
    }


    public Long getId() {
        return id;
    }

    public void atualizarStatus(EstadoAnalise analise) {
        this.analise = analise.toProposta();
    }

    public String getNome() {
        return nome;
    }

    public String getDocumento() {
        return documento;
    }

    public void insereNumeroCartao(String numeroCartao) {
        @Size(min = 19, max = 19)
        String cartao = numeroCartao;
        this.numeroCartao = cartao;
    }
}
