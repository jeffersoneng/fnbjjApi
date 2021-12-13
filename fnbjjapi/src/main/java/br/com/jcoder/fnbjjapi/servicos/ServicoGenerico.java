package br.com.jcoder.fnbjjapi.servicos;

import java.util.Collection;
import java.util.Optional;

public interface ServicoGenerico <T, ID> {
     T salvar(T entity);
     void deletarById(ID id);
     void deletarByEntity(T entity);
     Collection<T> buscarTodos();
     Optional<T> buscarPorId(ID id);
}
