package br.com.zupacademy.adriano.microservicepropostas.enums;

public enum EstadoAnalise {
    COM_RESTRICAO{
        @Override
        public EstadoProposta toProposta() {
            return EstadoProposta.NAO_ELEGIVEL;
        }
    },
    SEM_RESTRICAO {
        @Override
        public EstadoProposta toProposta() {
            return EstadoProposta.ELEGIVEL;
        }
    },

    APROVADO {
        @Override
        public EstadoProposta toProposta() {
            return EstadoProposta.ELEGIVEL;
        }
    };

    public abstract EstadoProposta toProposta();
}
