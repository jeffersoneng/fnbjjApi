package br.com.jcoder.fnbjjapi.controladores;

import br.com.jcoder.fnbjjapi.modelos.Atleta;
import br.com.jcoder.fnbjjapi.servicos.ServicoDoAtleta;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/atleta")
@CrossOrigin(origins = "*")
public class ControladorDoAtleta implements ControladorGenerico<Atleta, Integer>{

    private final ServicoDoAtleta servicoDoAtleta;

    ControladorDoAtleta(ServicoDoAtleta servicoDoAtleta){
        this.servicoDoAtleta = servicoDoAtleta;
    }

    @Override
    @GetMapping
    public ResponseEntity<List<Atleta>> buscarTodas() {
        return new ResponseEntity<>(new ArrayList<>(this.servicoDoAtleta.buscarTodos()), HttpStatus.OK);
    }

    @Override
    @PostMapping
    public ResponseEntity<Atleta> adicionar(@RequestBody @Valid Atleta atleta) {
        return new ResponseEntity<>(this.servicoDoAtleta.salvar(atleta), HttpStatus.CREATED);
    }

    @Override
    @GetMapping("/{id}")
    public ResponseEntity<Atleta> buscarPorId(@PathVariable Integer id) {
        Optional<Atleta> atleta = this.servicoDoAtleta.buscarPorId(id);
        return atleta.map(value -> new ResponseEntity<>(value, HttpStatus.OK)).orElseGet(() -> new ResponseEntity<>(HttpStatus.NOT_FOUND));
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

    @Override
    @PutMapping("/{id}")
    public ResponseEntity<Atleta> atualizar(@PathVariable Integer id,@RequestBody @Valid Atleta entity) {
        Optional<Atleta> optionalAtleta = this.servicoDoAtleta.buscarPorId(id);

        if(optionalAtleta.isPresent()){
            Atleta atleta = optionalAtleta.get();

            atleta.setDataMatricula(entity.getDataMatricula());
            atleta.setMatricula(entity.getMatricula());
            atleta.setAcademia(entity.getAcademia());
            atleta.setPessoa(entity.getPessoa());


        }


        return null;
    }
}
