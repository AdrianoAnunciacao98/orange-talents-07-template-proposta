package br.com.zupacademy.adriano.microservicepropostas.controller;

import br.com.zupacademy.adriano.microservicepropostas.consultadados.AnaliseSolicitante;
import br.com.zupacademy.adriano.microservicepropostas.response.ConsultaDadosResponse;
import br.com.zupacademy.adriano.microservicepropostas.exception.ExceptionErroApi;
import br.com.zupacademy.adriano.microservicepropostas.model.SolicitanteProposta;
import br.com.zupacademy.adriano.microservicepropostas.repository.SolicitanteRepository;
import br.com.zupacademy.adriano.microservicepropostas.request.PropostaRequest;
import br.com.zupacademy.adriano.microservicepropostas.response.EstadoPropostaResponse;
import br.com.zupacademy.adriano.microservicepropostas.validacao.VerificaSolicitacaoProposta;
import feign.FeignException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.util.UriComponentsBuilder;

import javax.validation.Valid;
import java.net.URI;
import java.util.Optional;

@RestController
@RequestMapping("/propostas")
public class SolicitaPropostaController {

    @Autowired
    private SolicitanteRepository solicitanteRepository;

  @Autowired
  private AnaliseSolicitante analiseSolicitante;

    @Autowired
    private VerificaSolicitacaoProposta verifica;

    @InitBinder
    public void init(WebDataBinder binder) {
     this.analiseSolicitante = analiseSolicitante;
    }

    @PostMapping
    public ResponseEntity<?> fazerProposta(@RequestBody @Valid PropostaRequest req, UriComponentsBuilder uriBuilder){
        Optional<SolicitanteProposta> verificaPropostaa = solicitanteRepository.findByDocumento(req.getDocumento());
        if(verificaPropostaa.isPresent())
            return ResponseEntity.status(422).build();

        SolicitanteProposta proposta = req.toModel();

        solicitanteRepository.save(proposta);

        try {
            ConsultaDadosResponse analise = analiseSolicitante.solicitarAnalise(proposta.analisarSolicitante());
            proposta.atualizarStatus(analise.getResultadoConsulta());
            solicitanteRepository.save(proposta);
        }
        catch (FeignException e) {
            throw new ExceptionErroApi(HttpStatus.BAD_REQUEST, "Erro ao analisar solicitante", "analise_solicitante");
        }
            URI uri = uriBuilder.path("/propostas/{id}").buildAndExpand(proposta.getId()).toUri();
            return ResponseEntity.created(uri).build();
        }



    @GetMapping("/{id}")
    public ResponseEntity<EstadoPropostaResponse> statusProposta(@PathVariable Long id) {
        Optional<SolicitanteProposta> propostaBanco = solicitanteRepository.findById(id);

        if (propostaBanco.isEmpty())
            return ResponseEntity.notFound().build();

        return ResponseEntity.ok(new EstadoPropostaResponse(propostaBanco.get()));
    }
    }






