package br.com.zupacademy.adriano.microservicepropostas.geracartao;

import br.com.zupacademy.adriano.microservicepropostas.model.Aviso;
import br.com.zupacademy.adriano.microservicepropostas.model.Cartao;

import java.time.LocalDateTime;

public class AvisoViagemRequest {
    private LocalDateTime validoAte;
    private String destino;

    public AvisoViagemRequest(LocalDateTime validoAte, String destino) {
        this.validoAte = validoAte;
        this.destino = destino;
    }

    public LocalDateTime getValidoAte() {
        return validoAte;
    }

    public String getDestino() {
        return destino;
    }

    public Aviso toModel(Cartao cartao, String enderecoIp, String userAgent){
        return new Aviso(validoAte, enderecoIp, userAgent, destino, cartao);
    }
}
