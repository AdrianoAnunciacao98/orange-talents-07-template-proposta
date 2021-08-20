package br.com.zupacademy.adriano.microservicepropostas.response;

public class ExceptionDto {

    private String field;
    private String error;
    private String causa;

    public ExceptionDto(String field, String error) {
        this.field = field;
        this.error = error;
    }

    public String getField() {
        return field;
    }

    public String getCausa() {
        return causa;
    }
}
