package br.com.zupacademy.adriano.microservicepropostas.validacao;

import javax.validation.Constraint;
import javax.validation.Payload;
import java.lang.annotation.Retention;
import java.lang.annotation.Target;

import static java.lang.annotation.ElementType.FIELD;
import static java.lang.annotation.RetentionPolicy.RUNTIME;

@Target(FIELD)
@Retention(RUNTIME)
@Constraint(validatedBy = Base64Valid.class)
public @interface Base64 {

    String message() default "Valor incompativel para Base64";

    Class<?>[] groups() default { };

    Class<? extends Payload>[] payload() default { };
}
