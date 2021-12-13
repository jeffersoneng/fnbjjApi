package br.com.jcoder.fnbjjapi.repositorios;

import br.com.jcoder.fnbjjapi.modelos.Atleta;
import org.springframework.data.jpa.repository.JpaRepository;

public interface RepositorioDoAtleta extends JpaRepository<Atleta, Integer> {
}
