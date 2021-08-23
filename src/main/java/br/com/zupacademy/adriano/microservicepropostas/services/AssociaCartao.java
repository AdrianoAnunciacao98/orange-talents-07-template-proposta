package br.com.zupacademy.adriano.microservicepropostas.services;


import br.com.zupacademy.adriano.microservicepropostas.associacartao.ConsultarCartaoClient;
import br.com.zupacademy.adriano.microservicepropostas.enums.EstadoProposta;
import br.com.zupacademy.adriano.microservicepropostas.model.Cartao;
import br.com.zupacademy.adriano.microservicepropostas.model.SolicitanteProposta;
import br.com.zupacademy.adriano.microservicepropostas.repository.CartaoRepository;
import br.com.zupacademy.adriano.microservicepropostas.repository.SolicitanteRepository;
import br.com.zupacademy.adriano.microservicepropostas.response.DadosCartaoResponse;
import feign.FeignException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;

import java.util.List;
import java.util.Objects;

public class AssociaCartao {

    @Autowired
    private  ConsultarCartaoClient consultarCartaoClient;

    @Autowired
    private  SolicitanteRepository propostaRepository;

    @Autowired
    private  CartaoRepository cartaoRepository;

    @Autowired
    private DadosCartaoResponse response;


    @Scheduled(fixedDelay = 50000)
   public void associarCartaoEProposta() {

     List<SolicitanteProposta> propostasSemCartao = propostaRepository.findByEstadoPropostaAndCartaoIsNull(EstadoProposta.ELEGIVEL);
       propostasSemCartao.forEach(p -> {
           Cartao cartao = consultarCartao(p.getId());
           if (Objects.nonNull(cartao)){
               cartaoRepository.save(cartao);
            }
        });
   }

   private Cartao consultarCartao(Long id) {
        try{
            DadosCartaoResponse response = consultarCartaoClient.consultarCartaoByProposta(String.valueOf(id));
            return response.toModel(propostaRepository);
        }catch (FeignException e) {
            return null;
        }
    }
}
