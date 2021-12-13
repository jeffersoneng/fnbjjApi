package br.com.jcoder.fnbjjapi.servicos.implementacoes;

import br.com.jcoder.fnbjjapi.servicos.ServicoGenerico;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Collection;
import java.util.Optional;

public class IServicoGenerico <T, ID> implements ServicoGenerico<T, ID> {

    private JpaRepository<T, ID> repository;

    IServicoGenerico(JpaRepository<T, ID> repository){
        this.repository = repository;
    }

    @Override
    public T salvar(T entity) {
        return repository.save(entity);
    }

    @Override
    public void deletarById(ID id) {
        repository.deleteById(id);
    }

    @Override
    public void deletarByEntity(T entity) {
        repository.delete(entity);
    }

    @Override
    public Collection<T> buscarTodos() {
        return repository.findAll();
    }

    @Override
    public Optional<T> buscarPorId(ID id) {
        return repository.findById(id);
    }
}
