package br.com.zupacademy.adriano.microservicepropostas.model;

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

    public SolicitanteProposta(String nome, double salario, String documento, Endereco endereco, String email) {
        this.nome = nome;
        this.salario = salario;
        this.documento = documento;
        this.endereco = endereco;
        this.email = email;
    }

    public Long getId() {
        return id;
    }
}
