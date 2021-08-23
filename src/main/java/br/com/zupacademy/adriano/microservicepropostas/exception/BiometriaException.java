package br.com.zupacademy.adriano.microservicepropostas.exception;

import org.springframework.http.HttpStatus;

public class BiometriaException extends RuntimeException{

    private final HttpStatus httpStatus;

    private final String reason;


    public BiometriaException(HttpStatus httpStatus, String reason) {
        this.httpStatus = httpStatus;
        this.reason = reason;
    }

    public HttpStatus getHttpStatus() {
        return httpStatus;
    }

    public String getReason() {
        return reason;
    }
}
