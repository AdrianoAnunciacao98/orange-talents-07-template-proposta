package br.com.zupacademy.adriano.microservicepropostas.associacartao;

import br.com.zupacademy.adriano.microservicepropostas.config.ResultadoResponse;
import br.com.zupacademy.adriano.microservicepropostas.geracartao.AvisoViagemRequest;
import br.com.zupacademy.adriano.microservicepropostas.request.BloqueiaCartaoRequest;
import br.com.zupacademy.adriano.microservicepropostas.request.CarteiraRequest;
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

    @PostMapping(value = "/cartoes/{id}/bloqueios")
    ResultadoResponse solicitaBloqueio(@PathVariable String id, @RequestBody BloqueiaCartaoRequest request);

    @PostMapping(value = "/cartoes/{id}/avisos")
    ResultadoResponse avisa(@PathVariable String id, @RequestBody @Valid AvisoViagemRequest request);

    @PostMapping(value = "/cartoes/{id}/carteiras")
    ResultadoResponse associaCarteira(@PathVariable String id, @RequestBody @Valid CarteiraRequest request);
}
