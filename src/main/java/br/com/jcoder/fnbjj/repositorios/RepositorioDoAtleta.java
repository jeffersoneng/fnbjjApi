package br.com.jcoder.fnbjj.repositorios;

import br.com.jcoder.fnbjj.modelos.Atleta;
import org.springframework.data.jpa.repository.JpaRepository;

public interface RepositorioDoAtleta extends JpaRepository<Atleta, Integer> {
}
