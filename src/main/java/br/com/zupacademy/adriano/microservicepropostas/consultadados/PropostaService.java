package br.com.zupacademy.adriano.microservicepropostas.consultadados;

import br.com.zupacademy.adriano.microservicepropostas.enums.EstadoAnalise;
import br.com.zupacademy.adriano.microservicepropostas.model.SolicitanteProposta;
import org.springframework.stereotype.Service;

@Service
public class PropostaService {
    private ConsultaRestricao consultaRestricao;

    public PropostaService(ConsultaRestricao consultaRestricao) {
        this.consultaRestricao = consultaRestricao;
    }

    public EstadoAnalise getEstadoProposta(SolicitanteProposta proposta) {
        ConsultaDadosRequest consultaRestricaoRequest = new ConsultaDadosRequest(proposta);
        ConsultaDadosResponse response = consultaRestricao.getPropostaResponse(consultaRestricaoRequest);
        String resultadoSolicitacao = response.getResultadoConsulta();

        if (resultadoSolicitacao.equals("COM_RESTRICAO")){
            proposta.setAnalise(EstadoAnalise.NAO_ELEGIVEL);
            return EstadoAnalise.NAO_ELEGIVEL;
        }
        proposta.setAnalise(EstadoAnalise.ELEGIVEL);
        return EstadoAnalise.ELEGIVEL;
    }
}
