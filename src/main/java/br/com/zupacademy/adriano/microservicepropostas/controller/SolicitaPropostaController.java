package br.com.zupacademy.adriano.microservicepropostas.controller;

import br.com.zupacademy.adriano.microservicepropostas.model.SolicitanteProposta;
import br.com.zupacademy.adriano.microservicepropostas.repository.SolicitanteRepository;
import br.com.zupacademy.adriano.microservicepropostas.request.SolicitantePropostaRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.util.UriComponentsBuilder;

import javax.validation.Valid;
import java.net.URI;

@RestController
@RequestMapping(path = "/api/v1/solicitaProposta")
public class SolicitaPropostaController {

    @Autowired
    private SolicitanteRepository solicitanteRepository;

    @PostMapping
    public ResponseEntity<?> fazerProposta(@RequestBody @Valid SolicitantePropostaRequest req, UriComponentsBuilder uriBuilder){
        SolicitanteProposta proposta = solicitanteRepository.save(req.toModel());
        if(proposta == null){
            return ResponseEntity.badRequest().build();
        }
        else {
            URI uri = uriBuilder.path("/propostas/{id}").buildAndExpand(proposta.getId()).toUri();
            return ResponseEntity.created(uri).build();
        }

    }
}
