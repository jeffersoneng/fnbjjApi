package br.com.jcoder.fnbjjapi.servicos;

import br.com.jcoder.fnbjjapi.modelos.Atleta;
import br.com.jcoder.fnbjjapi.modelos.Graduacao;

import java.util.List;
import java.util.Optional;

public interface ServicoDaGraduacao extends ServicoGenerico<Graduacao, Integer>{

    Optional<List<Graduacao>> findByAtleta(Atleta atleta);

}
