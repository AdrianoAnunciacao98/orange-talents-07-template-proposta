package br.com.zupacademy.adriano.microservicepropostas.repository;

import br.com.zupacademy.adriano.microservicepropostas.model.BloqueiaCartao;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface BloqueiaCartaoRepository extends JpaRepository<BloqueiaCartao, Long> {
    Optional<BloqueiaCartao> findByCartaoId(String id);
}
