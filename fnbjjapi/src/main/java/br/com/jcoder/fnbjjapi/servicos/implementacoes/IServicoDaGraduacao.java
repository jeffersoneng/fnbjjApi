package br.com.jcoder.fnbjjapi.servicos.implementacoes;

import br.com.jcoder.fnbjjapi.modelos.Atleta;
import br.com.jcoder.fnbjjapi.modelos.Graduacao;
import br.com.jcoder.fnbjjapi.repositorios.RepositorioDeGraduacao;
import br.com.jcoder.fnbjjapi.servicos.ServicoDaGraduacao;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class IServicoDaGraduacao extends IServicoGenerico<Graduacao, Integer> implements ServicoDaGraduacao {

    private RepositorioDeGraduacao repositorioDeGraduacao;

    IServicoDaGraduacao(RepositorioDeGraduacao repositorioDeGraduacao) {
        super(repositorioDeGraduacao);
        this.repositorioDeGraduacao = repositorioDeGraduacao;
    }

    @Override
    public Optional<List<Graduacao>> findByAtleta(Atleta atleta) {
        return this.repositorioDeGraduacao.findByAtleta(atleta);
    }
}
