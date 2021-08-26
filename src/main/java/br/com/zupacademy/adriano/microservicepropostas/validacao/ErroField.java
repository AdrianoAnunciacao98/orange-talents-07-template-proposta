package br.com.zupacademy.adriano.microservicepropostas.validacao;

public class ErroField {
    private String field;
    private String message;

    public ErroField(String field, String message) {
        this.field = field;
        this.message = message;
    }

    public String getField() {
        return field;
    }

    public String getMessage() {
        return message;
    }
}

