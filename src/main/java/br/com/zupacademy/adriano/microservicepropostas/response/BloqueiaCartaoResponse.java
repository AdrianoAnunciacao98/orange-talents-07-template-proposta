package br.com.zupacademy.adriano.microservicepropostas.response;

import br.com.zupacademy.adriano.microservicepropostas.enums.EstadoBloqueio;
import br.com.zupacademy.adriano.microservicepropostas.model.BloqueiaCartao;
import br.com.zupacademy.adriano.microservicepropostas.model.Cartao;
import br.com.zupacademy.adriano.microservicepropostas.repository.CartaoRepository;
import org.springframework.http.HttpStatus;

import javax.servlet.http.HttpServletRequest;
import javax.validation.constraints.NotBlank;

public class BloqueiaCartaoResponse {

    @NotBlank
    private EstadoBloqueio estado;

    public EstadoBloqueio getEstado() {
        return estado;
    }

    public BloqueiaCartao toModel(CartaoRepository cartaoRepository, HttpServletRequest req, Cartao cartao){
        String ipCliente = req.getRemoteAddr();
        String userAgent = req.getHeader("User-Agent");
        return new BloqueiaCartao(cartao, ipCliente, userAgent);
    }
}
