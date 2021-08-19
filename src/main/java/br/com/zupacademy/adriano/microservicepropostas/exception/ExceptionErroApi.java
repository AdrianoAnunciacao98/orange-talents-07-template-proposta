package br.com.zupacademy.adriano.microservicepropostas.exception;

import org.springframework.http.HttpStatus;

public class ExceptionErroApi extends RuntimeException{

    private  HttpStatus httpStatus;
    private  String reason;
    private  String field;


    public ExceptionErroApi(HttpStatus httpStatus, String reason, String field) {
        this.httpStatus = httpStatus;
        this.reason = reason;
        this.field = field;
    }

    public HttpStatus getHttpStatus() {
        return httpStatus;
    }

    public String getReason() {
        return reason;
    }

    public String getField() {
        return field;
    }
}
