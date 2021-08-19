package br.com.zupacademy.adriano.microservicepropostas.controller;

import br.com.zupacademy.adriano.microservicepropostas.consultadados.AnaliseSolicitante;
import br.com.zupacademy.adriano.microservicepropostas.consultadados.ConsultaDadosResponse;
import br.com.zupacademy.adriano.microservicepropostas.enums.EstadoProposta;
import br.com.zupacademy.adriano.microservicepropostas.geracartao.EstadoPropostaResponse;
import br.com.zupacademy.adriano.microservicepropostas.model.SolicitanteProposta;
import br.com.zupacademy.adriano.microservicepropostas.repository.SolicitanteRepository;
import br.com.zupacademy.adriano.microservicepropostas.request.SolicitantePropostaRequest;
import br.com.zupacademy.adriano.microservicepropostas.validacao.VerificaProposta;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.*;
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
    private VerificaProposta verificaProposta;

    @Autowired
    private AnaliseSolicitante analiseSolicitante;

    @InitBinder
    public void init(WebDataBinder binder) {
       this.analiseSolicitante = analiseSolicitante;
    }

    @PostMapping
    public ResponseEntity<?> fazerProposta(@RequestBody @Valid SolicitantePropostaRequest req, UriComponentsBuilder uriBuilder){
        Optional<SolicitanteProposta> verificaPropostaa = solicitanteRepository.findByDocumento(req.getDocumento());

           if(verificaPropostaa.isPresent())

            return ResponseEntity.status(422).build();

           SolicitanteProposta proposta = req.toModel();

           solicitanteRepository.save(proposta);

        ConsultaDadosResponse analisar = analiseSolicitante.enviar(proposta);
        proposta.atualizarStatus(analisar.getResultadoConsulta());

            URI uri = uriBuilder.path("/propostas/{id}").buildAndExpand(proposta.getId()).toUri();
            return ResponseEntity.created(uri).build();
        }


    @GetMapping(path = "/{id}")
    public EstadoPropostaResponse buscaEstadoProposta(@PathVariable("id") Long id) throws PropostaNotFoundException {
        SolicitanteProposta proposta = solicitanteRepository.findById(id).orElseThrow(() -> new PropostaNotFoundException(id));
        EstadoPropostaResponse response = new EstadoPropostaResponse(proposta.getId(), proposta.getNome(), proposta.getEstado());
        return response;
    }




    }

