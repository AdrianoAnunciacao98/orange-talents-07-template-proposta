package br.com.zupacademy.adriano.microservicepropostas.consultadados;

import br.com.zupacademy.adriano.microservicepropostas.response.ConsultaDadosResponse;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

@FeignClient(name="Analise-Solicitante", url = "${ANALISE_HOST}")
public interface AnaliseSolicitante {

    @PostMapping("api/solicitacao")
    ConsultaDadosResponse solicitarAnalise(@RequestBody ConsultaDadosRequest request);
}
