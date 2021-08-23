package br.com.zupacademy.adriano.microservicepropostas.validacao;

import br.com.zupacademy.adriano.microservicepropostas.exception.BiometriaException;
import org.springframework.http.HttpStatus;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

public class Base64Valid implements ConstraintValidator<Base64, String> {
    @Override
    public boolean isValid(String value, ConstraintValidatorContext constraintValidatorContext) {
        try {
            new String(java.util.Base64.getDecoder().decode(value));
            return true;

        } catch (IllegalArgumentException e) {
            throw  new BiometriaException(HttpStatus.BAD_REQUEST, constraintValidatorContext.getDefaultConstraintMessageTemplate());
        }

    }
}
