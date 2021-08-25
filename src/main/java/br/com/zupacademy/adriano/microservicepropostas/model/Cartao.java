package br.com.zupacademy.adriano.microservicepropostas.model;

import br.com.zupacademy.adriano.microservicepropostas.enums.EstadoCartao;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

import static br.com.zupacademy.adriano.microservicepropostas.enums.EstadoCartao.*;
import static javax.persistence.CascadeType.*;

@Entity
public class Cartao {

    @Id
    @NotBlank
    private String id;

    @NotNull
    private LocalDateTime emitidoEm;

    @NotBlank
    private String titular;

    @NotNull
    private BigDecimal limite;

    @ManyToOne
    private SolicitanteProposta proposta;

    @NotNull
    @Enumerated(EnumType.STRING)
    private EstadoCartao estado;





    public void bloqueioConfirmadoNoLegado() {
        this.estado = BLOQUEADO;
    }

    public Cartao(String id, LocalDateTime emitidoEm, String titular, BigDecimal limite, SolicitanteProposta proposta) {
        this.id = id;
        this.emitidoEm = emitidoEm;
        this.titular = titular;
        this.limite = limite;
        this.proposta = proposta;
        this.estado = ATIVO;
    }

    public String getId() {
        return id;
    }

    public LocalDateTime getEmitidoEm() {
        return emitidoEm;
    }

    public String getTitular() {
        return titular;
    }

    public BigDecimal getLimite() {
        return limite;
    }

    public SolicitanteProposta getProposta() {
        return proposta;
    }

    @Override
    public String toString() {
        return "Cartao{" +
                "id='" + id + '\'' +
                ", emitidoEm=" + emitidoEm +
                ", titular='" + titular + '\'' +
                ", limite=" + limite +
                ", proposta=" + proposta +
                '}';
    }

    public boolean estaBloqueado() {
        return estado.equals(BLOQUEADO) || estado.equals(BLOQUEIO_PENDENTE);
    }

    public void fazAviso( Aviso aviso) {
  //      this.avisos.add(aviso);
    }
}
