package br.com.zupacademy.adriano.microservicepropostas.repository;

import br.com.zupacademy.adriano.microservicepropostas.enums.EscolhaCarteira;
import br.com.zupacademy.adriano.microservicepropostas.model.Carteira;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CarteiraRepository extends JpaRepository<Carteira, Long> {
    boolean existsByNomeAndCartaoId(EscolhaCarteira nome, Long id);
}
