package br.com.zupacademy.adriano.microservicepropostas.controller;

import br.com.zupacademy.adriano.microservicepropostas.associacartao.ConsultarCartaoClient;
import br.com.zupacademy.adriano.microservicepropostas.enums.EstadoBloqueio;
import br.com.zupacademy.adriano.microservicepropostas.exception.ExceptionErroApi;
import br.com.zupacademy.adriano.microservicepropostas.model.BloqueiaCartao;
import br.com.zupacademy.adriano.microservicepropostas.model.Cartao;
import br.com.zupacademy.adriano.microservicepropostas.repository.BloqueiaCartaoRepository;
import br.com.zupacademy.adriano.microservicepropostas.repository.CartaoRepository;
import br.com.zupacademy.adriano.microservicepropostas.request.BloqueiaCartaoRequest;
import br.com.zupacademy.adriano.microservicepropostas.response.BloqueiaCartaoResponse;
import br.com.zupacademy.adriano.microservicepropostas.response.ExceptionDto;
import feign.FeignException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import java.util.Optional;

@RestController
public class BloqueiaCartaoController {

    @Autowired
    private BloqueiaCartaoRepository bloqueioRepository;
    @Autowired
    private ConsultarCartaoClient consulta;
    @Autowired
    private CartaoRepository cartaoRep;

    @PostMapping("/cartoes/{id}/bloqueio")
    public ResponseEntity<?> bloquearCartao(@PathVariable String id, HttpServletRequest request) {
        Optional<Cartao> cartaoBanco = cartaoRep.findById(id);

        if(cartaoBanco.isEmpty())
            return ResponseEntity.notFound().build();

        Optional<BloqueiaCartao> bloqueioBanco = bloqueioRepository.findByCartaoId(id);
        if(bloqueioBanco.isPresent())
            return ResponseEntity.status(422).body(new ExceptionDto("request", "Cartão já bloqueado"));

        try{
            BloqueiaCartaoRequest bloqueioRequest = new BloqueiaCartaoRequest("Proposta");
            BloqueiaCartaoResponse bloqueioResponse = consulta.bloquearCartao(id, bloqueioRequest);

            if(bloqueioResponse.getEstado().equals(EstadoBloqueio.BLOQUEADO)){
               BloqueiaCartao bloqueio = bloqueioResponse.toModel(cartaoRep, request, cartaoBanco.get());
              bloqueioRepository.save(bloqueio);
           }
           else
                throw new ExceptionErroApi(422, "Não foi possível realizar bloqueio", "request");
        }catch (FeignException e){
            return ResponseEntity.status(422).body(new ExceptionDto("request", "Não foi possível realizar bloqueio"));
        }

        return ResponseEntity.ok().build();
    }

}
