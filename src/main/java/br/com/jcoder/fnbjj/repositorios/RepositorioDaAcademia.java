package br.com.jcoder.fnbjj.repositorios;

import br.com.jcoder.fnbjj.modelos.Academia;
import br.com.jcoder.fnbjj.modelos.Federacao;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Collection;
import java.util.Optional;

public interface RepositorioDaAcademia extends JpaRepository<Academia, Integer> {
    Collection<Academia> findAcademiasByFederacao(Federacao federacao);
    Optional<Academia> findAcademiaByRegistro(String registro);
}
