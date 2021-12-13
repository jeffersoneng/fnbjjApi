package br.com.jcoder.fnbjjapi.servicos.implementacoes;

import br.com.jcoder.fnbjjapi.modelos.Atleta;
import br.com.jcoder.fnbjjapi.servicos.ServicoDoAtleta;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Service;

@Service
public class IServicoDoAtleta extends IServicoGenerico<Atleta, Integer> implements ServicoDoAtleta {

    IServicoDoAtleta(JpaRepository<Atleta, Integer> repository) {
        super(repository);
    }
}
