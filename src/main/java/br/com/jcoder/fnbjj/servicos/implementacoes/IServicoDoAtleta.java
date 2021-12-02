package br.com.jcoder.fnbjj.servicos.implementacoes;

import br.com.jcoder.fnbjj.modelos.Atleta;
import br.com.jcoder.fnbjj.servicos.ServicoDoAtleta;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Service;

@Service
public class IServicoDoAtleta extends IServicoGenerico<Atleta, Integer> implements ServicoDoAtleta {

    IServicoDoAtleta(JpaRepository<Atleta, Integer> repository) {
        super(repository);
    }
}
