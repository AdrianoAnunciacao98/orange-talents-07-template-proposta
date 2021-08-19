package br.com.zupacademy.adriano.microservicepropostas.validacao;

import br.com.zupacademy.adriano.microservicepropostas.exception.ExceptionErroApi;
import br.com.zupacademy.adriano.microservicepropostas.model.SolicitanteProposta;
import br.com.zupacademy.adriano.microservicepropostas.repository.SolicitanteRepository;
import br.com.zupacademy.adriano.microservicepropostas.request.SolicitantePropostaRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.Validator;

import java.util.Optional;

@Component
public class VerificaProposta implements Validator {


    @Autowired
    private  SolicitanteRepository solicitanteRepository;



    @Override
    public boolean supports(Class<?> aClass) {
        return SolicitantePropostaRequest.class.isAssignableFrom(aClass);
    }

    @Override
    public void validate(Object o, Errors errors) {
        if(errors.hasErrors())
            return;

        SolicitantePropostaRequest request = (SolicitantePropostaRequest) o;

        Optional<SolicitanteProposta> propostaBanco = solicitanteRepository.findByDocumento(request.getDocumento());

        if(propostaBanco.isPresent())
            throw new ExceptionErroApi(HttpStatus.UNPROCESSABLE_ENTITY, "Proposta já cadastrada para esse solicitante", "documento");
    }
    }

