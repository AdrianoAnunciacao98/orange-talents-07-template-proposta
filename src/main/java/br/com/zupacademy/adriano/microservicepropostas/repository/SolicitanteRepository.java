package br.com.zupacademy.adriano.microservicepropostas.repository;

import br.com.zupacademy.adriano.microservicepropostas.model.SolicitanteProposta;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface SolicitanteRepository extends JpaRepository<SolicitanteProposta, Long> {
    Optional<SolicitanteProposta> findByDocumento(String documento);
}
