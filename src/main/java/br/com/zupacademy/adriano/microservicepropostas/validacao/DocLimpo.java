package br.com.zupacademy.adriano.microservicepropostas.validacao;

import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

import javax.validation.Valid;
import javax.validation.constraints.NotBlank;

public class DocLimpo {

        private String doc;

        @Valid
        public  DocLimpo(String doc) {
            this.doc = doc;
        }

        public String documentoEncriptado() {
            return new BCryptPasswordEncoder().encode(doc);
        }
    }

