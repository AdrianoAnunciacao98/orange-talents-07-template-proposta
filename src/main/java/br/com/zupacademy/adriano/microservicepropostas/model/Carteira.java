package br.com.zupacademy.adriano.microservicepropostas.model;

import br.com.zupacademy.adriano.microservicepropostas.enums.EscolhaCarteira;

import javax.persistence.*;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import java.util.Objects;

@Entity
public class Carteira {

    @Id
    @GeneratedValue
    private Long id;

    @NotNull
    @Enumerated(EnumType.STRING)
    private EscolhaCarteira nome;

    @NotNull
    @NotBlank
    @Email
    private String email;


    @NotNull
    @ManyToOne
    private Cartao cartao;

    @Deprecated
    public Carteira() {
    }

    public Carteira(EscolhaCarteira nome, String email, Cartao cartao) {
        this.nome = nome;
        this.email = email;
        this.cartao = cartao;
    }

    public Long getId() {
        return id;
    }



}

