package br.com.zupacademy.adriano.microservicepropostas.associacartao;

import br.com.zupacademy.adriano.microservicepropostas.request.BloqueiaCartaoRequest;
import br.com.zupacademy.adriano.microservicepropostas.response.BloqueiaCartaoResponse;
import br.com.zupacademy.adriano.microservicepropostas.response.ConsultaDadosResponse;
import br.com.zupacademy.adriano.microservicepropostas.response.DadosCartaoResponse;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@FeignClient(name="cartoes", url = "${CARTAO_HOST}")
public interface ConsultarCartaoClient {

    @GetMapping("/api/cartoes")
    DadosCartaoResponse consultarCartaoByProposta(@RequestParam String idProposta);
    @PostMapping("/api/cartoes/{id}/bloqueios")
    BloqueiaCartaoResponse bloquearCartao(@PathVariable String id, @RequestBody @Valid BloqueiaCartaoRequest request);
}
