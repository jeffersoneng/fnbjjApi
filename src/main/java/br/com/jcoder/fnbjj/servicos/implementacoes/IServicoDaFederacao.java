package br.com.jcoder.fnbjj.servicos.implementacoes;

import br.com.jcoder.fnbjj.modelos.Federacao;
import br.com.jcoder.fnbjj.repositorios.RepositorioDaFederacao;
import br.com.jcoder.fnbjj.servicos.ServicoDaFederacao;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class IServicoDaFederacao extends IServicoGenerico<Federacao, Integer> implements ServicoDaFederacao {

    private RepositorioDaFederacao repositorioDaFederacao;

    IServicoDaFederacao(RepositorioDaFederacao repositorioDaFederacao){
        super(repositorioDaFederacao);
        this.repositorioDaFederacao = repositorioDaFederacao;
    }

    @Override
    public Optional<Federacao> findByCnpj(String cnpj) {
        return repositorioDaFederacao.findByCnpj(cnpj);
    }
}
