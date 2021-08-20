package br.com.zupacademy.adriano.microservicepropostas.repository;

import br.com.zupacademy.adriano.microservicepropostas.model.Cartao;
import org.springframework.data.repository.CrudRepository;

import java.util.Optional;

public interface CartaoRepository extends CrudRepository<Cartao, Long> {

    Optional<Cartao> findById(String id);
}
