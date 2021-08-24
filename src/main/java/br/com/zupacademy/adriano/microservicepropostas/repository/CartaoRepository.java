package br.com.zupacademy.adriano.microservicepropostas.repository;

import br.com.zupacademy.adriano.microservicepropostas.enums.EstadoCartao;
import br.com.zupacademy.adriano.microservicepropostas.model.Cartao;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.repository.CrudRepository;

import java.util.Optional;

public interface CartaoRepository extends CrudRepository<Cartao, Long> {

    Optional<Cartao> findById(String id);
    Page<Cartao> findAllByEstado(EstadoCartao estado, Pageable pageable);
}
