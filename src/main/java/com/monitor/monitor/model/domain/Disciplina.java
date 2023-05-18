package com.monitor.monitor.model.domain;

import com.monitor.monitor.model.dto.DisciplinaDTO;
import jakarta.persistence.*;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.CreationTimestamp;

import java.time.LocalDateTime;
import java.util.List;

@Entity
@Data
@NoArgsConstructor
public class Disciplina {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String sigla;

    private String descricao;

    @ElementCollection
    @CollectionTable(name = "assuntos", joinColumns = @JoinColumn(name = "id"))
    @Column(name = "assuntos")
    private List<String> assuntos;

    private boolean status;

    @Column(name = "data_lancamento")
    @CreationTimestamp
    private LocalDateTime dataLancamento;

    public Disciplina(DisciplinaDTO disciplina) {
        this.sigla = disciplina.sigla();
        this.descricao = disciplina.descricao();
        this.assuntos = disciplina.assuntos();
        this.status = disciplina.status();
    }
}
