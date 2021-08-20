package br.com.zupacademy.adriano.microservicepropostas.services;

import br.com.zupacademy.adriano.microservicepropostas.consultadados.ConsultaDadosRequest;
import br.com.zupacademy.adriano.microservicepropostas.response.ConsultaDadosResponse;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

@FeignClient(name="analiseSolicitante", url = "http://localhost:8888")
public interface AnaliseCliente {

    @PostMapping("api/solicitacao")
    ConsultaDadosResponse solicitarAnalise(@RequestBody ConsultaDadosRequest request);

}
