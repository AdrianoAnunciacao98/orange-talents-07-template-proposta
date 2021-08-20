package br.com.zupacademy.adriano.microservicepropostas.validacao;

import br.com.zupacademy.adriano.microservicepropostas.exception.ExceptionErroApi;
import br.com.zupacademy.adriano.microservicepropostas.model.SolicitanteProposta;
import br.com.zupacademy.adriano.microservicepropostas.repository.SolicitanteRepository;
import br.com.zupacademy.adriano.microservicepropostas.request.PropostaRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.Validator;

import java.util.Optional;

@Component
public class VerificaSolicitacaoProposta implements Validator {

    @Autowired
    private SolicitanteRepository repository;

    @Override
    public boolean supports(Class<?> aClass) {
        return PropostaRequest.class.isAssignableFrom(aClass);
    }

    @Override
    public void validate(Object o, Errors errors) {
        if(errors.hasErrors())
            return;

        PropostaRequest request = (PropostaRequest) o;

        Optional<SolicitanteProposta> propostaBanco = repository.findByDocumento(request.getDocumento());

        if(propostaBanco.isPresent())
            throw new ExceptionErroApi(HttpStatus.UNPROCESSABLE_ENTITY, "Proposta já cadastrada para esse solicitante", "documento");
    }
    }

