package br.com.jcoder.fnbjjapi.controladores;

import br.com.jcoder.fnbjjapi.modelos.Federacao;
import br.com.jcoder.fnbjjapi.servicos.ServicoDaFederacao;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/federacao")
@CrossOrigin(origins = "*")
public class ControladorDaFederacao implements ControladorGenerico<Federacao, Integer>{

    private final ServicoDaFederacao servicoDaFederacao;

    ControladorDaFederacao(ServicoDaFederacao servicoDaFederacao){
        this.servicoDaFederacao = servicoDaFederacao;
    }

    @GetMapping
    public ResponseEntity<List<Federacao>> buscarTodas(){
        return new ResponseEntity<>((List<Federacao>) this.servicoDaFederacao.buscarTodos(), HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<Federacao> adicionar(@RequestBody @Valid Federacao federacao){
        return new ResponseEntity<>(this.servicoDaFederacao.salvar(federacao), HttpStatus.CREATED);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Federacao> buscarPorId(@PathVariable Integer id){
        Optional<Federacao> federacao = this.servicoDaFederacao.buscarPorId(id);
        return federacao.map(value -> new ResponseEntity<>(value, HttpStatus.OK)).orElseGet(() -> new ResponseEntity<>(HttpStatus.NOT_FOUND));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> deletar(@PathVariable Integer id){
        Optional<Federacao> federacao = this.servicoDaFederacao.buscarPorId(id);
        if (federacao.isPresent()){
            this.servicoDaFederacao.deletarById(federacao.get().getId());
            return new ResponseEntity<>(HttpStatus.OK);
        }else{
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }
}
