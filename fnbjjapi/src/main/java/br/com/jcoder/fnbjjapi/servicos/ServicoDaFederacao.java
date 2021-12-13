package br.com.jcoder.fnbjjapi.servicos;

import br.com.jcoder.fnbjjapi.modelos.Federacao;

import java.util.Optional;

public interface ServicoDaFederacao extends ServicoGenerico<Federacao, Integer> {
    Optional<Federacao> findByCnpj(String cnpj);

}
