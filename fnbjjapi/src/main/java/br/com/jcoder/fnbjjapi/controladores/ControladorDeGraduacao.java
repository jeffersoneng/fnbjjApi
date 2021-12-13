package br.com.jcoder.fnbjjapi.controladores;

import br.com.jcoder.fnbjjapi.modelos.Atleta;
import br.com.jcoder.fnbjjapi.modelos.Graduacao;
import br.com.jcoder.fnbjjapi.servicos.ServicoDaGraduacao;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/graduacao")
@CrossOrigin("*")
public class ControladorDeGraduacao implements ControladorGenerico<Graduacao, Integer> {

    private final ServicoDaGraduacao servicoDaGraduacao;

    ControladorDeGraduacao(ServicoDaGraduacao servicoDaGraduacao) {
        this.servicoDaGraduacao = servicoDaGraduacao;
    }

    @Override
    @GetMapping
    public ResponseEntity<List<Graduacao>> buscarTodas() {
        return ResponseEntity
                .ok(new ArrayList<>(this.servicoDaGraduacao.buscarTodos()));
    }

    @Override
    @PostMapping
    public ResponseEntity<Graduacao> adicionar(@RequestBody @Valid Graduacao entity) {
        return ResponseEntity
                .status(HttpStatus.CREATED)
                .body(this.servicoDaGraduacao.salvar(entity));
    }

    @Override
    @GetMapping("/{id}")
    public ResponseEntity<Graduacao> buscarPorId(@PathVariable Integer id) {
        Optional<Graduacao> graduacao = this.servicoDaGraduacao.buscarPorId(id);

        return graduacao.map(ResponseEntity::ok).orElseGet(() -> ResponseEntity
                .notFound()
                .build());
    }

    @Override
    @DeleteMapping("/{id}")
    public ResponseEntity<?> deletar(@PathVariable Integer id) {
        Optional<Graduacao> graduacao = this.servicoDaGraduacao.buscarPorId(id);
        if(graduacao.isPresent()){
            this.servicoDaGraduacao.deletarById(id);
            return new ResponseEntity<>(HttpStatus.OK);
        }else{
            return ResponseEntity.notFound().build();
        }
    }

    @Override
    @PutMapping("/{id}")
    public ResponseEntity<Graduacao> atualizar(@PathVariable Integer id,@RequestBody @Valid Graduacao entity) {
        Optional<Graduacao> optionalGraduacao = this.servicoDaGraduacao.buscarPorId(id);

        if(optionalGraduacao.isPresent()){
            Graduacao graduacao = optionalGraduacao.get();

            graduacao.setDataGraduacao(entity.getDataGraduacao());
            graduacao.setFaixa(entity.getFaixa());
            graduacao.setGrau(entity.getGrau());
            graduacao.setAtleta(entity.getAtleta());

            Graduacao graduacaoAtualizada = this.servicoDaGraduacao.salvar(graduacao);

            return ResponseEntity.ok(graduacaoAtualizada);
        }else{
            return ResponseEntity.notFound().build();
        }
    }

    @GetMapping("/atleta/{id}")
    public ResponseEntity<List<Graduacao>> buscarPorAtleta(@PathVariable Integer id){
        Atleta atleta = new Atleta();
        atleta.setId(id);

        Optional<List<Graduacao>> graduacaoList = this.servicoDaGraduacao.findByAtleta(atleta);

        if ((graduacaoList.isPresent())){
            List<Graduacao> graduacoes = graduacaoList.get();
            return new ResponseEntity<>(graduacoes, HttpStatus.OK);
        }else{
            return ResponseEntity.notFound().build();
        }

    }
}
