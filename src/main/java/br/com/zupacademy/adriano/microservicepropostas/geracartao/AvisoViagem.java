package br.com.zupacademy.adriano.microservicepropostas.geracartao;

import java.time.LocalDateTime;

public class AvisoViagem {
    private LocalDateTime validoAte;
    private String destino;

    public AvisoViagem(LocalDateTime validoAte, String destino) {
        this.validoAte = validoAte;
        this.destino = destino;
    }

    public LocalDateTime getValidoAte() {
        return validoAte;
    }

    public String getDestino() {
        return destino;
    }
}
