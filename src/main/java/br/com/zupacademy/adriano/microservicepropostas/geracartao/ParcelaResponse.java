package br.com.zupacademy.adriano.microservicepropostas.geracartao;

public class ParcelaResponse {

    private String id;
    private int quantidade;
    private double valor;

    public ParcelaResponse(String id, int quantidade, double valor) {
        this.id = id;
        this.quantidade = quantidade;
        this.valor = valor;
    }

    public String getId() {
        return id;
    }

    public int getQuantidade() {
        return quantidade;
    }

    public double getValor() {
        return valor;
    }



}
