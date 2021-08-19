package br.com.zupacademy.adriano.microservicepropostas.geracartao;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@FeignClient(name = "geradorCartao", url = "http://localhost:8888/api/cartoes")
public interface GerarCartaoApi {

    @RequestMapping(method = RequestMethod.POST)
    CartaoResponse getCartaoGeradoResponse(GerarCartaoRequest gerarCartaoRequest);
}
