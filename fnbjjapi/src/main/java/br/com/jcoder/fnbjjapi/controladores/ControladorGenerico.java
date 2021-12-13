package br.com.jcoder.fnbjjapi.controladores;

import org.springframework.http.ResponseEntity;

import java.util.List;

public interface ControladorGenerico<T, ID> {
    ResponseEntity<List<T>> buscarTodas();
    ResponseEntity<T> adicionar(T entity);
    ResponseEntity<T> buscarPorId(ID id);
    ResponseEntity<?> deletar(ID id);
}
