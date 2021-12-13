package br.com.jcoder.fnbjjapi.modelos;

import lombok.Data;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;
import java.time.LocalDate;

@Data
@Entity
public class Pessoa {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    private Integer id;

    @NotBlank(message = "Informe um nome")
    @Size(min = 3, message = "Informe um nome com pelo menos 3 caracteres")
    private String nome;

    private LocalDate dataNascimento;
}
