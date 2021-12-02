package br.com.jcoder.fnbjj.modelos;

import lombok.Data;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;
import java.time.LocalDate;

@Data
@Entity
public class Academia {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    private Integer id;

    @NotBlank(message = "Informe um nome")
    @Size(min = 3, message = "Nome deve possuir no mínimo 3 letrar")
    private String nome;

    @NotBlank(message = "Informe o registro")
    private String registro;

    private LocalDate dataFundacao;

    private Boolean ativa;

    @ManyToOne
    @JoinColumn(name = "federacao_id", foreignKey = @ForeignKey(name = "FK_academia_federacao"))
    private Federacao federacao;
}
