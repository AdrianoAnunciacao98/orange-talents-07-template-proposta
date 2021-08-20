package br.com.zupacademy.adriano.microservicepropostas.services;


import br.com.zupacademy.adriano.microservicepropostas.associacartao.AssociarCartao;
import br.com.zupacademy.adriano.microservicepropostas.associacartao.ConsultarCartaoClient;
import br.com.zupacademy.adriano.microservicepropostas.enums.EstadoProposta;
import br.com.zupacademy.adriano.microservicepropostas.model.Cartao;
import br.com.zupacademy.adriano.microservicepropostas.model.SolicitanteProposta;
import br.com.zupacademy.adriano.microservicepropostas.repository.CartaoRepository;
import br.com.zupacademy.adriano.microservicepropostas.repository.SolicitanteRepository;
import br.com.zupacademy.adriano.microservicepropostas.response.ConsultaDadosResponse;
import br.com.zupacademy.adriano.microservicepropostas.response.DadosCartaoResponse;
import feign.FeignException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.scheduling.annotation.Scheduled;

import java.util.List;
import java.util.Objects;

public class AssociaCartao {

    private final ConsultarCartaoClient consultarCartaoClient;
    private final SolicitanteRepository propostaRepository;
    private final CartaoRepository cartaoRepository;
   private final Logger logger;

    private DadosCartaoResponse response;

    public AssociaCartao(ConsultarCartaoClient consultarCartaoClient, SolicitanteRepository propostaRepository, CartaoRepository cartaoRepository) {
        this.consultarCartaoClient = consultarCartaoClient;
        this.propostaRepository = propostaRepository;
        this.cartaoRepository = cartaoRepository;
       this.logger = LoggerFactory.getLogger(AssociarCartao.class);
    }

    @Scheduled(cron = "0 */5 * ? * *") //Executa a cada 5 minutos
   public void associarCartaoEProposta() {
       logger.info("Verificando cartões...");

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
