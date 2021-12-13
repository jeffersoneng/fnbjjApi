package br.com.jcoder.fnbjjapi.repositorios;

import br.com.jcoder.fnbjjapi.modelos.Federacao;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface RepositorioDaFederacao extends JpaRepository<Federacao, Integer> {
    Optional<Federacao> findByCnpj(String cnpj);
}
