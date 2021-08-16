package br.com.zupacademy.adriano.microservicepropostas.exception;

public class ExceptionResponse {

    private String campo;
    private String erro;

    public ExceptionResponse(String campo, String erro) {
        this.campo = campo;
        this.erro = erro;
    }

    public String getCampo() {
        return campo;
    }

    public String getErro() {
        return erro;
    }

    public void setErro(String erro) {
        this.erro = erro;
    }



}








