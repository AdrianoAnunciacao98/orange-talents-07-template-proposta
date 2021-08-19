package br.com.zupacademy.adriano.microservicepropostas.geracartao;

import br.com.zupacademy.adriano.microservicepropostas.model.SolicitanteProposta;
import br.com.zupacademy.adriano.microservicepropostas.repository.SolicitanteRepository;
import feign.FeignException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;

import javax.transaction.Transactional;
import java.util.List;

import static br.com.zupacademy.adriano.microservicepropostas.enums.EstadoProposta.ELEGIVEL;

public class GerarCartao {

    @Autowired
    private SolicitanteRepository solicitanteRepository;
    @Autowired
    private GerarCartaoApi gerarCartaoApi;

    @Scheduled(fixedDelay = 20000)
    @Transactional
    private void executarOperacao() {
        List<SolicitanteProposta> propostasElegiveis = solicitanteRepository.findAllByEstado(ELEGIVEL);
        for (SolicitanteProposta proposta : propostasElegiveis) {
            GerarCartaoRequest cartaoRequest = new GerarCartaoRequest(proposta);
            CartaoResponse response = null;
            try {
                response = gerarCartaoApi.getCartaoGeradoResponse(cartaoRequest);
                getNumeroCartao(proposta, response);
            } catch (FeignException e) {
                e.getMessage();
            }

        }
    }

    private void getNumeroCartao(SolicitanteProposta proposta, CartaoResponse response) {
        String numeroCartao = response.getId();
        if (numeroCartao != null) {
            proposta.insereNumeroCartao(numeroCartao);
            solicitanteRepository.save(proposta);
        }
    }
}
