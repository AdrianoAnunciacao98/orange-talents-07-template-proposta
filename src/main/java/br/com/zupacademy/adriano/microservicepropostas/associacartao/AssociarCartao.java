package br.com.zupacademy.adriano.microservicepropostas.associacartao;

import br.com.zupacademy.adriano.microservicepropostas.enums.EstadoProposta;
import br.com.zupacademy.adriano.microservicepropostas.model.Cartao;
import br.com.zupacademy.adriano.microservicepropostas.repository.CartaoRepository;
import br.com.zupacademy.adriano.microservicepropostas.response.ConsultaDadosResponse;
import br.com.zupacademy.adriano.microservicepropostas.model.SolicitanteProposta;
import br.com.zupacademy.adriano.microservicepropostas.repository.SolicitanteRepository;
import br.com.zupacademy.adriano.microservicepropostas.response.DadosCartaoResponse;
import feign.FeignException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class AssociarCartao {

   private final ConsultarCartaoClient consultarCartaoClient;
    private final SolicitanteRepository propostaRepository;
    private final Logger logger;

   private final CartaoRepository cartaoRepository;

    public AssociarCartao(ConsultarCartaoClient consultarCartaoClient,
                          SolicitanteRepository propostaRepository, CartaoRepository cartaoRepository) {
        this.consultarCartaoClient = consultarCartaoClient;
        this.propostaRepository = propostaRepository;
        this.logger = LoggerFactory.getLogger(AssociarCartao.class);
        this.cartaoRepository = cartaoRepository;
    }

    @Scheduled(cron = "0 */5 * ? * *")
    public void associarCartaoEProposta() {
       logger.info("Verificando cartões...");

        List<SolicitanteProposta> propostasSemCartao = propostaRepository.findByEstadoPropostaAndCartaoIsNull(EstadoProposta.ELEGIVEL);

       propostasSemCartao.forEach(p -> {
           Cartao cartao = consultarCartao(p.getId());
           if (cartao != null){
               cartaoRepository.save(cartao);
            }

       });

      propostaRepository.saveAll(propostasSemCartao);
  }
   private Cartao consultarCartao(Long id) {
       try{
           DadosCartaoResponse response = consultarCartaoClient.consultarCartaoByProposta(String.valueOf(id));
           return response.toModel(propostaRepository);
       }catch (FeignException e) {
           return null;
       }
   }}
