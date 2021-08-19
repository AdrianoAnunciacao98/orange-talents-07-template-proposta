package br.com.zupacademy.adriano.microservicepropostas.consultadados;

import br.com.zupacademy.adriano.microservicepropostas.exception.ExceptionErroApi;
import br.com.zupacademy.adriano.microservicepropostas.model.SolicitanteProposta;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.HttpClientErrorException;
import org.springframework.web.client.RestTemplate;

@Service
public class AnaliseSolicitante {

    public ConsultaDadosResponse enviar(SolicitanteProposta proposta){
        RestTemplate restTemplate = new RestTemplate();
        String url = "http://localhost:9999/api/solicitacao";

        ConsultaDadosRequest request = new ConsultaDadosRequest(proposta.getDocumento(), proposta.getNome(), proposta.getId().toString());

        try{
            ResponseEntity<ConsultaDadosResponse> response = restTemplate.postForEntity(url, request, ConsultaDadosResponse.class);
            return response.getBody();
        }
        catch (HttpClientErrorException e){
            throw new ExceptionErroApi(HttpStatus.BAD_REQUEST, "Problemas na análise da consulta", "request");
        }
    }
}
