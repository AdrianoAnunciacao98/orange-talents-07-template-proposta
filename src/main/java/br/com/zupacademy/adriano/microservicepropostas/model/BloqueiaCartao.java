package br.com.zupacademy.adriano.microservicepropostas.model;

import javax.persistence.*;
import java.time.Instant;

@Entity
public class BloqueiaCartao {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @OneToOne
    private Cartao cartao;

    private String ipCliente;

    private String userAgent;

    private Instant instanteBloqueio = Instant.now();

    @Deprecated
    public BloqueiaCartao(){}

    public BloqueiaCartao(Cartao cartao, String ipCliente, String userAgent) {
        this.cartao = cartao;
        this.ipCliente = ipCliente;
        this.userAgent = userAgent;
    }
}
