package br.com.jcoder.fnbjj.controladores;

import br.com.jcoder.fnbjj.modelos.Federacao;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.List;

public interface ControladorGenerico<T, ID> {
    ResponseEntity<List<T>> buscarTodas();
    ResponseEntity<T> adicionar(T entity);
    ResponseEntity<T> buscarPorId(ID id);
    ResponseEntity<?> deletar(ID id);
}
