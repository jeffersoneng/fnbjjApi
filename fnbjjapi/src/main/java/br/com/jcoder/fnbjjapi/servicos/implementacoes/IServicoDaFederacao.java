package br.com.jcoder.fnbjjapi.servicos.implementacoes;

import br.com.jcoder.fnbjjapi.modelos.Federacao;
import br.com.jcoder.fnbjjapi.repositorios.RepositorioDaFederacao;
import br.com.jcoder.fnbjjapi.servicos.ServicoDaFederacao;
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
