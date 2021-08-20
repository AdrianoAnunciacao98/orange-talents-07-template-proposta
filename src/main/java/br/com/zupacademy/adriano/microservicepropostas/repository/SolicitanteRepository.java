package br.com.zupacademy.adriano.microservicepropostas.repository;

import br.com.zupacademy.adriano.microservicepropostas.enums.EstadoProposta;
import br.com.zupacademy.adriano.microservicepropostas.model.SolicitanteProposta;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface SolicitanteRepository extends CrudRepository<SolicitanteProposta, Long> {
     Optional<SolicitanteProposta> findByDocumento(String documento);


    List<SolicitanteProposta> findByEstadoPropostaAndCartaoIsNull(EstadoProposta status);
}
