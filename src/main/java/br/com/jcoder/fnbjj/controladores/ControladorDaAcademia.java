package br.com.jcoder.fnbjj.controladores;

import br.com.jcoder.fnbjj.modelos.Academia;
import br.com.jcoder.fnbjj.modelos.Federacao;
import br.com.jcoder.fnbjj.servicos.ServicoDaAcademia;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/academia")
@CrossOrigin(value = "*")
public class ControladorDaAcademia implements ControladorGenerico<Academia, Integer> {

    private ServicoDaAcademia servicoDaAcademia;

    ControladorDaAcademia(ServicoDaAcademia servicoDaAcademia) {
        this.servicoDaAcademia = servicoDaAcademia;
    }

    @Override
    @GetMapping
    public ResponseEntity<List<Academia>> buscarTodas() {
        return ResponseEntity
                .ok(this.servicoDaAcademia.buscarTodos().stream().collect(Collectors.toList()));
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

        if (academia.isPresent()) {
            return ResponseEntity
                    .ok(academia.get());
        } else {
            return ResponseEntity
                    .notFound()
                    .build();
        }
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

    @GetMapping("/federacao/{id}")
    public ResponseEntity<List<Academia>> buscarPorFederacao(@PathVariable Integer id) {
        Federacao federacao = new Federacao();
        federacao.setId(id);
        return new ResponseEntity<List<Academia>>(this.servicoDaAcademia.findAcademiasByFederacao(federacao).stream().collect(Collectors.toList()), HttpStatus.OK);
    }
}
