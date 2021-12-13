package br.com.jcoder.fnbjjapi.repositorios;

import br.com.jcoder.fnbjjapi.modelos.Atleta;
import br.com.jcoder.fnbjjapi.modelos.Graduacao;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface RepositorioDeGraduacao extends JpaRepository<Graduacao, Integer> {

    Optional<List<Graduacao>> findByAtleta(Atleta atleta);

}