package br.com.jcoder.fnbjj.servicos;

import br.com.jcoder.fnbjj.modelos.Federacao;
import br.com.jcoder.fnbjj.servicos.ServicoGenerico;

import java.util.Optional;

public interface ServicoDaFederacao extends ServicoGenerico<Federacao, Integer> {
    Optional<Federacao> findByCnpj(String cnpj);

}
