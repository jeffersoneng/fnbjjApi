package br.com.jcoder.fnbjj.modelos;

import lombok.Data;
import org.hibernate.validator.constraints.br.CNPJ;
import org.springframework.data.jpa.domain.AbstractAuditable;
import org.springframework.data.jpa.domain.AbstractPersistable;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;
import java.time.LocalDate;

@Data
@Entity
public class Federacao {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @NotBlank(message = "Informe um nome")
    @Size(min = 3, message = "Informe um nome com 3 letras no mínimo")
    private String nome;

    @CNPJ(message = "Informe um CNPJ válido")
    @Column(unique = true)
    private String cnpj;

    private LocalDate dataFundacao;

    private Boolean ativa = true;
}
