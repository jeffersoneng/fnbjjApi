package br.com.jcoder.fnbjjapi.modelos;

import lombok.Data;

import javax.persistence.*;
import java.time.LocalDate;

@Data
@Entity
public class Atleta {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    private Integer id;

    @Column(unique = true, nullable = false)
    private String matricula;

    @Column(nullable = false)
    private LocalDate dataMatricula = LocalDate.now();

    @ManyToOne
    @JoinColumn(name = "academia_id", foreignKey = @ForeignKey(name = "fk_atleta_academia"))
    private Academia academia;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "pessoa_id", foreignKey = @ForeignKey(name = "fk_atleta_pessoa"))
    private Pessoa pessoa;
}
