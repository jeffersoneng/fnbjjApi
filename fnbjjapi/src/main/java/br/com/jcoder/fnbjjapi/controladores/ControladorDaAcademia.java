package br.com.jcoder.fnbjjapi.controladores;

import br.com.jcoder.fnbjjapi.modelos.Academia;
import br.com.jcoder.fnbjjapi.modelos.Federacao;
import br.com.jcoder.fnbjjapi.servicos.ServicoDaAcademia;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/academia")
@CrossOrigin(value = "*")
public class ControladorDaAcademia implements ControladorGenerico<Academia, Integer> {

    private final ServicoDaAcademia servicoDaAcademia;

    ControladorDaAcademia(ServicoDaAcademia servicoDaAcademia) {
        this.servicoDaAcademia = servicoDaAcademia;
    }

    @Override
    @GetMapping
    public ResponseEntity<List<Academia>> buscarTodas() {
        return ResponseEntity
                .ok(new ArrayList<>(this.servicoDaAcademia.buscarTodos()));
    }

    @Override
    @PostMapping
    public ResponseEntity<Academia> adicionar(@RequestBody Academia academia) {
        return ResponseEntity
                .status(HttpStatus.CREATED)
                .body(this.servicoDaAcademia.salvar(academia));
    }

    @Override
    @GetMapping("/{id}")
    public ResponseEntity<Academia> buscarPorId(@PathVariable Integer id) {
        Optional<Academia> academia = this.servicoDaAcademia.buscarPorId(id);

        return academia.map(ResponseEntity::ok).orElseGet(() -> ResponseEntity
                .notFound()
                .build());
    }

    @Override
    @DeleteMapping("/{id}")
    public ResponseEntity<?> deletar(@PathVariable Integer id) {
        Optional<Academia> academia = this.servicoDaAcademia.buscarPorId(id);
        if (academia.isPresent()) {
            this.servicoDaAcademia.deletarById(academia.get().getId());
            return new ResponseEntity<>(HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @Override
    @PutMapping("/{id}")
    public ResponseEntity<Academia> atualizar(@PathVariable Integer id,@RequestBody @Valid Academia entity) {
        Optional<Academia> optionalAcademia = this.servicoDaAcademia.buscarPorId(id);

        if(optionalAcademia.isPresent()){
            Academia academia = optionalAcademia.get();
            academia.setAtiva(entity.getAtiva());
            academia.setDataFundacao(entity.getDataFundacao());
            academia.setNome(entity.getNome());
            academia.setRegistro(entity.getRegistro());
            academia.setFederacao(entity.getFederacao());

            final Academia academiaAtualizada = this.servicoDaAcademia.salvar(academia);
            return ResponseEntity.ok(academiaAtualizada);
        }else{
            return ResponseEntity.notFound().build();
        }
    }

    @GetMapping("/federacao/{id}")
    public ResponseEntity<List<Academia>> buscarPorFederacao(@PathVariable Integer id) {
        Federacao federacao = new Federacao();
        federacao.setId(id);
        return new ResponseEntity<>(new ArrayList<>(this.servicoDaAcademia.findAcademiasByFederacao(federacao)), HttpStatus.OK);
    }
}
