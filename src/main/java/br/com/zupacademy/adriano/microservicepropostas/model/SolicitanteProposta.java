package br.com.zupacademy.adriano.microservicepropostas.model;

import br.com.zupacademy.adriano.microservicepropostas.consultadados.ConsultaDadosRequest;
import br.com.zupacademy.adriano.microservicepropostas.enums.EstadoAnalise;
import br.com.zupacademy.adriano.microservicepropostas.enums.EstadoProposta;

import javax.persistence.*;
import javax.validation.constraints.NotNull;

@Entity
public class SolicitanteProposta {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private String nome;

    @Column(nullable = false)
    private double salario;

    @Column(nullable = false)
    private String documento;

    @Column(nullable = false)
    private String endereco;

    @Column(nullable = false)
    private String email;

    @Enumerated(EnumType.STRING)
    @NotNull
    private EstadoProposta estadoProposta;


    @OneToOne(mappedBy = "proposta", cascade = CascadeType.MERGE)
    private Cartao cartao;




    public SolicitanteProposta(String nome, double salario, String documento, String endereco, String email) {
        this.nome = nome;
        this.salario = salario;
        this.documento = documento;
        this.endereco = endereco;
        this.email = email;
        this.estadoProposta = EstadoProposta.NAO_ELEGIVEL;
    }


    public Long getId() {
        return id;
    }

    public void atualizarStatus(EstadoAnalise analise) {
        this.estadoProposta = analise.toProposta();
    }

    public String getNome() {
        return nome;
    }

    public String getDocumento() {
        return documento;
    }

    public ConsultaDadosRequest analisarSolicitante(){
        return new ConsultaDadosRequest(documento, nome, id.toString());
    }



    public double getSalario() {
        return salario;
    }

    public String getEndereco() {
        return endereco;
    }

    public String getEmail() {
        return email;
    }

    public EstadoProposta getAnalise() {
        return estadoProposta;
    }

}
