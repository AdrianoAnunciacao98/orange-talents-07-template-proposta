package br.com.zupacademy.adriano.microservicepropostas.response;

import br.com.zupacademy.adriano.microservicepropostas.model.Cartao;
import br.com.zupacademy.adriano.microservicepropostas.model.SolicitanteProposta;
import br.com.zupacademy.adriano.microservicepropostas.repository.SolicitanteRepository;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.Optional;

public class DadosCartaoResponse {
    @NotBlank
    private String id;

    @NotBlank
    private String titular;

    @NotBlank
    private Long idProposta;

    @NotNull
    private LocalDateTime emitidoEm;

    @NotNull
    private BigDecimal limite;

    public DadosCartaoResponse(Cartao cartao) {
        this.id = cartao.getId();
        this.titular = cartao.getTitular();
        this.idProposta = cartao.getProposta().getId();
        this.emitidoEm = cartao.getEmitidoEm();
        this.limite = cartao.getLimite();
    }

    @Deprecated
    public DadosCartaoResponse() {}

    public Cartao toModel(SolicitanteRepository propostaRepository){
        Optional<SolicitanteProposta> propostaBanco = propostaRepository.findById(idProposta);

        return new Cartao(id, emitidoEm, titular, limite, propostaBanco.get());
    }

    public String getId() {
        return id;
    }

    public String getTitular() {
        return titular;
    }

    public Long getIdProposta() {
        return idProposta;
    }

    public LocalDateTime getEmitidoEm() {
        return emitidoEm;
    }

    public BigDecimal getLimite() {
        return limite;
    }
}
