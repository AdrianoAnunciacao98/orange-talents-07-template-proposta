package br.com.zupacademy.adriano.microservicepropostas.exception;

public class ExceptionDto {

    private String causa;
    private String erro;

    public ExceptionDto(String causa, String erro) {
        this.causa = causa;
        this.erro = erro;
    }

    public String getCausa() {
        return causa;
    }

    public String getErro() {
        return erro;
    }
}
