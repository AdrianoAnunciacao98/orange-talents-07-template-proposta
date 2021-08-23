package br.com.zupacademy.adriano.microservicepropostas.model;

import javax.persistence.*;
import java.time.LocalDateTime;

@Entity
public class Biometria {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private String fingerprint;

    private LocalDateTime localDateTime = LocalDateTime.now();

    @ManyToOne
    private Cartao cartao;

    @Deprecated
    public Biometria(){}

    public Biometria(Long id, String fingerprint, LocalDateTime localDateTime) {
        this.id = id;
        this.fingerprint = fingerprint;
        this.localDateTime = localDateTime;
    }

    public Biometria(String fingerprint, Cartao cartao) {
        this.fingerprint = fingerprint;
        this.cartao = cartao;
    }

    public Long getId() {
        return id;
    }


}
