package br.com.jcoder.fnbjjapi.modelos;

import br.com.jcoder.fnbjjapi.enumaradores.Faixa;
import br.com.jcoder.fnbjjapi.enumaradores.Grau;
import lombok.Data;

import javax.persistence.*;
import java.time.LocalDate;

@Data
@Entity
public class Graduacao {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    private Long id;

    @Column(name = "dataGraduacao")
    private LocalDate dataGraduacao = LocalDate.now();

    @Enumerated(EnumType.STRING)
    private Faixa faixa;

    @Enumerated(EnumType.STRING)
    private Grau grau;

    @ManyToOne
    @JoinColumn(name = "atleta_id", foreignKey = @ForeignKey(name = "fk_graduacao_atleta"))
    private Atleta atleta;

}
