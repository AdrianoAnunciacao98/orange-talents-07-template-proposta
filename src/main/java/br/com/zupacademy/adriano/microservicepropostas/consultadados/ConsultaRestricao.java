package br.com.zupacademy.adriano.microservicepropostas.consultadados;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@FeignClient(name = "consultaRestricao", url = "http://localhost:9999/api/consulta")
public interface ConsultaRestricao {

    @RequestMapping(method = RequestMethod.POST)
    ConsultaDadosResponse getPropostaResponse(ConsultaDadosRequest consultaDadosRequest);

}
