package br.com.jcoder.fnbjjapi.controladores;

import br.com.jcoder.fnbjjapi.modelos.Atleta;
import br.com.jcoder.fnbjjapi.servicos.ServicoDoAtleta;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/atleta")
@CrossOrigin(origins = "*")
public class ControladorDoAtleta implements ControladorGenerico<Atleta, Integer>{

    private ServicoDoAtleta servicoDoAtleta;

    ControladorDoAtleta(ServicoDoAtleta servicoDoAtleta){
        this.servicoDoAtleta = servicoDoAtleta;
    }

    @Override
    @GetMapping
    public ResponseEntity<List<Atleta>> buscarTodas() {
        return new ResponseEntity<List<Atleta>>(this.servicoDoAtleta.buscarTodos().stream().collect(Collectors.toList()), HttpStatus.OK);
    }

    @Override
    @PostMapping
    public ResponseEntity<Atleta> adicionar(@RequestBody @Valid Atleta atleta) {
        return new ResponseEntity<Atleta>(this.servicoDoAtleta.salvar(atleta), HttpStatus.CREATED);
    }

    @Override
    @GetMapping("/{id}")
    public ResponseEntity<Atleta> buscarPorId(@PathVariable Integer id) {
        Optional<Atleta> atleta = this.servicoDoAtleta.buscarPorId(id);
        if(atleta.isPresent()){
            return new ResponseEntity< Atleta>(atleta.get(), HttpStatus.OK);
        }else{
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @Override
    @DeleteMapping("/{id}")
    public ResponseEntity<?> deletar(@PathVariable Integer id) {
        Optional<Atleta> atleta = this.servicoDoAtleta.buscarPorId(id);
        if(atleta.isPresent()){
            this.servicoDoAtleta.deletarById(id);
            return new ResponseEntity<>(HttpStatus.OK);
        }else{
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }
}
