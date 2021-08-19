package br.com.zupacademy.adriano.microservicepropostas.geracartao;

import java.time.LocalDateTime;
import java.util.List;

public class CartaoResponse {

    private String id;
    private LocalDateTime emitidoEm;
    private String titular;
    private List<BloqueioResponse> bloqueios;
    private List<AvisoViagem> avisos;
    private List<CarteiraResponse> carteiras;
    private List<ParcelaResponse> parcelas;
    private double limite;
    private RenegociacaoResponse renegociacao;
    private VencimentoResponse vencimentoResponse;
    private String idProposta;

    @Deprecated
    public CartaoResponse(){}

    public CartaoResponse(String id, LocalDateTime emitidoEm, String titular, List<BloqueioResponse> bloqueios,
                          List<AvisoViagem> avisos, List<CarteiraResponse> carteiras,
                          List<ParcelaResponse> parcelas, double limite, RenegociacaoResponse renegociacao,
                          VencimentoResponse vencimentoResponse, String idProposta) {
        this.id = id;
        this.emitidoEm = emitidoEm;
        this.titular = titular;
        this.bloqueios = bloqueios;
        this.avisos = avisos;
        this.carteiras = carteiras;
        this.parcelas = parcelas;
        this.limite = limite;
        this.renegociacao = renegociacao;
        this.vencimentoResponse = vencimentoResponse;
        this.idProposta = idProposta;
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

    public List<BloqueioResponse> getBloqueios() {
        return bloqueios;
    }

    public List<AvisoViagem> getAvisos() {
        return avisos;
    }

    public List<CarteiraResponse> getCarteiras() {
        return carteiras;
    }

    public List<ParcelaResponse> getParcelas() {
        return parcelas;
    }

    public double getLimite() {
        return limite;
    }

    public RenegociacaoResponse getRenegociacao() {
        return renegociacao;
    }

    public VencimentoResponse getVencimentoResponse() {
        return vencimentoResponse;
    }

    public String getIdProposta() {
        return idProposta;
    }

    @Override
    public String toString() {
        return "CartaoResponse{" +
                "id='" + id + '\'' +
                ", emitidoEm=" + emitidoEm +
                ", titular='" + titular + '\'' +
                ", bloqueios=" + bloqueios +
                ", avisos=" + avisos +
                ", carteiras=" + carteiras +
                ", parcelas=" + parcelas +
                ", limite=" + limite +
                ", renegociacao=" + renegociacao +
                ", vencimentoResponse=" + vencimentoResponse +
                ", idProposta='" + idProposta + '\'' +
                '}';
    }
}
