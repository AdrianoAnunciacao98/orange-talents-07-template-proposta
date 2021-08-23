package br.com.zupacademy.adriano.microservicepropostas.controller;

import br.com.zupacademy.adriano.microservicepropostas.model.Biometria;
import br.com.zupacademy.adriano.microservicepropostas.repository.BiometriaRepository;
import br.com.zupacademy.adriano.microservicepropostas.repository.CartaoRepository;
import br.com.zupacademy.adriano.microservicepropostas.request.BiometriaRequest;
import org.apache.tomcat.util.codec.binary.Base64;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.util.UriComponentsBuilder;

import javax.validation.Valid;
import java.net.URI;
import java.util.Optional;

@RestController
@RequestMapping("/biometria")
public class BiometriaController {

    @Autowired
    private BiometriaRepository biometriaRepository;

    @Autowired
    private CartaoRepository cartaoRepository;


    @PostMapping("/{cartaoId}")
    public ResponseEntity<?> postBio(@RequestBody @Valid BiometriaRequest request, @PathVariable String cartaoId, UriComponentsBuilder uriBuilder) {
        if(!verificaBase(request.getFingerprint()))
            return ResponseEntity.badRequest().build();

        Optional<Biometria> biometrias = request.toModel(cartaoRepository, cartaoId);

        if(biometrias.isEmpty())
            return ResponseEntity.notFound().build();

        Biometria biometria = biometrias.get();
        biometriaRepository.save(biometria);

        URI uri = uriBuilder.path("/biometria/{id}").buildAndExpand(biometria.getId()).toUri();
        return ResponseEntity.created(uri).build();
    }

    private boolean verificaBase(String valor) {
        return Base64.isBase64(valor);
    }


}
