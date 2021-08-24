package br.com.zupacademy.adriano.microservicepropostas.services;

import br.com.zupacademy.adriano.microservicepropostas.associacartao.ConsultarCartaoClient;
import br.com.zupacademy.adriano.microservicepropostas.config.TimeConfig;
import br.com.zupacademy.adriano.microservicepropostas.model.BloqueiaCartao;
import br.com.zupacademy.adriano.microservicepropostas.model.Cartao;
import br.com.zupacademy.adriano.microservicepropostas.repository.CartaoRepository;
import br.com.zupacademy.adriano.microservicepropostas.request.BloqueiaCartaoRequest;
import feign.FeignException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;

import static br.com.zupacademy.adriano.microservicepropostas.enums.EstadoCartao.BLOQUEIO_PENDENTE;

@Service
public class BloqueiaCartaoLegado {

        Logger log = LoggerFactory.getLogger(BloqueiaCartaoLegado.class);
        @Autowired
        private CartaoRepository cartaoRepository;
        @Autowired
        private ConsultarCartaoClient cartaoClient;

        @Scheduled(fixedDelay = 5 * TimeConfig.SEGUNDO)
        private void bloqueiaCartoes() {
            Pageable paginacao = PageRequest.ofSize(10);
            Page<Cartao> paginaDeCartoes = cartaoRepository.findAllByEstado(BLOQUEIO_PENDENTE, paginacao);

            while(paginaDeCartoes.hasNext()) {
                executaBloqueios(paginaDeCartoes);
                paginaDeCartoes = cartaoRepository.findAllByEstado(BLOQUEIO_PENDENTE, paginacao);
            }

            executaBloqueios(paginaDeCartoes);
        }

        private void executaBloqueios(Page<Cartao> paginaDeCartoes) {
            paginaDeCartoes.forEach(cartao -> {
                BloqueiaCartaoRequest request = new BloqueiaCartaoRequest();
                try {
                    cartaoClient.solicitaBloqueio(cartao.getId(), request);
                    cartao.bloqueioConfirmadoNoLegado();
                    cartaoRepository.save(cartao);
                    log.info("Cartão bloqueado no sistema legado: " + cartao.getId());
                } catch (FeignException e) {
                    log.error("Erro ao bloquear cartão no sistema legado: " + cartao.getId());
                }
            });
        }

    }
