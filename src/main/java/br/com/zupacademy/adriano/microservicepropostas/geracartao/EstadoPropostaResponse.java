package br.com.zupacademy.adriano.microservicepropostas.geracartao;

import br.com.zupacademy.adriano.microservicepropostas.enums.EstadoProposta;

public class EstadoPropostaResponse {

    public class EstadoPropostaResponse {
        private Long id;
        private String nome;
        private EstadoProposta estadoProposta;

        @Deprecated
        public EstadoPropostaResponse() {
        }

        public EstadoPropostaResponse(Long id, String nome, EstadoProposta estadoProposta) {
            this.id = id;
            this.nome = nome;
            this.estadoProposta = estadoProposta;
        }

        public Long getId() {
            return id;
        }

        public String getNome() {
            return nome;
        }

        public EstadoProposta getEstadoProposta() {
            return estadoProposta;
        }
    }
}
