package br.com.jcoder.fnbjj.servicos;

import br.com.jcoder.fnbjj.modelos.Academia;
import br.com.jcoder.fnbjj.modelos.Federacao;

import java.util.Collection;
import java.util.Optional;

public interface ServicoDaAcademia extends ServicoGenerico<Academia, Integer> {
    Collection<Academia> findAcademiasByFederacao(Federacao federacao);
    Optional<Academia> findAcademiaByRegistro(String registro);
}
