package br.com.zupacademy.adriano.microservicepropostas.controller;

import br.com.zupacademy.adriano.microservicepropostas.associacartao.ConsultarCartaoClient;
import br.com.zupacademy.adriano.microservicepropostas.geracartao.AvisoViagemRequest;
import br.com.zupacademy.adriano.microservicepropostas.model.Aviso;
import br.com.zupacademy.adriano.microservicepropostas.model.Cartao;
import br.com.zupacademy.adriano.microservicepropostas.repository.CartaoRepository;
import feign.FeignException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.server.ResponseStatusException;

import javax.servlet.http.HttpServletRequest;
import javax.transaction.Transactional;
import javax.validation.Valid;
import java.util.Optional;

public class AvisoViagemController {

    @Autowired
    private CartaoRepository cartaoRepository;

    @Autowired
    private ConsultarCartaoClient client;

    @PostMapping("/api/cartoes/{id}/avisos")
    @Transactional
    public ResponseEntity<?> avisar(@PathVariable String id,@RequestBody @Valid AvisoViagemRequest requestDto,
             @RequestHeader("User-Agent") String userAgent,
             @RequestHeader(value = "X-Forward-For") String xForwardFor,
             HttpServletRequest httpRequest) {
        Optional<Cartao> optionalCartao = cartaoRepository.findById(id);

        if (optionalCartao.isEmpty())
            return ResponseEntity.notFound().build();

        String split = xForwardFor.split(",")[0];
        Cartao cartao = optionalCartao.get();
        Aviso aviso = requestDto.toModel(cartao, split, userAgent);
        cartao.fazAviso(aviso);
        cartaoRepository.save(cartao);

        try {
            AvisoViagemRequest request = new AvisoViagemRequest(requestDto.getValidoAte(), requestDto.getDestino());
            client.avisa(id, request);
        } catch (FeignException.UnprocessableEntity ex) {
            throw new ResponseStatusException(HttpStatus.UNPROCESSABLE_ENTITY);
        } catch (FeignException.BadRequest ex) {
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST);
        } catch (FeignException ex) {
            throw new ResponseStatusException(HttpStatus.SERVICE_UNAVAILABLE);
        }
        return ResponseEntity.ok().build();
    }
}
