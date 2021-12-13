package br.com.jcoder.fnbjjapi.servicos;

import br.com.jcoder.fnbjjapi.modelos.Academia;
import br.com.jcoder.fnbjjapi.modelos.Federacao;

import java.util.Collection;
import java.util.Optional;

public interface ServicoDaAcademia extends ServicoGenerico<Academia, Integer> {
    Collection<Academia> findAcademiasByFederacao(Federacao federacao);
    Optional<Academia> findAcademiaByRegistro(String registro);
}
