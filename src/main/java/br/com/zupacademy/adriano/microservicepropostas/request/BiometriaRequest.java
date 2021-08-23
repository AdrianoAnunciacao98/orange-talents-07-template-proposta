package br.com.zupacademy.adriano.microservicepropostas.request;

import br.com.zupacademy.adriano.microservicepropostas.model.Biometria;
import br.com.zupacademy.adriano.microservicepropostas.model.Cartao;
import br.com.zupacademy.adriano.microservicepropostas.repository.CartaoRepository;
import br.com.zupacademy.adriano.microservicepropostas.validacao.Base64;

import javax.validation.constraints.NotBlank;
import java.util.Optional;

public class BiometriaRequest {

    @NotBlank
    @Base64
    private String fingerprint;

    public String getFingerprint() {
        return fingerprint;
    }

    public Optional<Biometria> toModel(CartaoRepository cartaoRepository, String cartaoId) {
        Optional<Cartao> cartaoBanco = cartaoRepository.findById(cartaoId);

        if(cartaoBanco.isPresent()){
            Cartao cartao = cartaoBanco.get();
            Biometria biometria = new Biometria(this.fingerprint, cartao);

            return Optional.of(biometria);
        }

        return Optional.empty();
    }
}
