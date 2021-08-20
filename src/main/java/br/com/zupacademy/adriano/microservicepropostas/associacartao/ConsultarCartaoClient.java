package br.com.zupacademy.adriano.microservicepropostas.associacartao;

import br.com.zupacademy.adriano.microservicepropostas.response.ConsultaDadosResponse;
import br.com.zupacademy.adriano.microservicepropostas.response.DadosCartaoResponse;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

@FeignClient(name="cartoes", url = "http://localhost:8888")
public interface ConsultarCartaoClient {
    @GetMapping("/api/cartoes")
    DadosCartaoResponse consultarCartaoByProposta(@RequestParam String idProposta);
}
