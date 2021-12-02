package br.com.jcoder.fnbjj.repositorios;

import br.com.jcoder.fnbjj.modelos.Federacao;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface RepositorioDaFederacao extends JpaRepository<Federacao, Integer> {
    Optional<Federacao> findByCnpj(String cnpj);
}
