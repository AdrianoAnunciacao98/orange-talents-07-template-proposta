package br.com.zupacademy.adriano.microservicepropostas.controller;

import br.com.zupacademy.adriano.microservicepropostas.consultadados.PropostaService;
import br.com.zupacademy.adriano.microservicepropostas.enums.EstadoAnalise;
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
import java.util.Optional;

@RestController
@RequestMapping(path = "/api/v1/solicitaProposta")
public class SolicitaPropostaController {

    @Autowired
    private SolicitanteRepository solicitanteRepository;

    @Autowired
    private PropostaService propostaService;

    @PostMapping
    public ResponseEntity<?> fazerProposta(@RequestBody @Valid SolicitantePropostaRequest req, UriComponentsBuilder uriBuilder){
        Optional<SolicitanteProposta> proposta = solicitanteRepository.findByDocumento(req.getDocumento());

        if(proposta.isEmpty()){
            return ResponseEntity.badRequest().build();
        }
        else {
            SolicitanteProposta propostaa = solicitanteRepository.save(req.toModel());
            EstadoAnalise estado = propostaService.getEstadoProposta(propostaa);
            URI uri = uriBuilder.path("/propostas/{id}").buildAndExpand(propostaa.getId(),propostaa.getDocumento(), propostaa.getNome(), estado).toUri();
            return ResponseEntity.created(uri).build();
        }

    }
}
