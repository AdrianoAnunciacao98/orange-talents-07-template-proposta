package br.com.zupacademy.adriano.microservicepropostas.request;

import br.com.zupacademy.adriano.microservicepropostas.enums.EscolhaCarteira;
import br.com.zupacademy.adriano.microservicepropostas.model.Cartao;
import br.com.zupacademy.adriano.microservicepropostas.model.Carteira;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;

public class CarteiraRequest {

    @Email
    @NotBlank
    private String email;

    private EscolhaCarteira escolhaCarteira;

    public CarteiraRequest(String email, EscolhaCarteira escolhaCarteira) {
        this.email = email;
        this.escolhaCarteira = escolhaCarteira;
    }

    public Carteira toModel(Cartao cartao){
        return new Carteira(escolhaCarteira,email,cartao);
    }

    public String getEmail() {
        return email;
    }

    public EscolhaCarteira getEscolhaCarteira() {
        return escolhaCarteira;
    }
}
