package com.monitor.monitor.model.domain;

import com.monitor.monitor.model.dto.MonitorDTO;
import jakarta.persistence.*;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.CreationTimestamp;

import java.time.LocalDateTime;

@Entity
@Data
@NoArgsConstructor
public class Monitor {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @OneToOne
    @JoinColumn(nullable = false)
    private Aluno aluno;

    @OneToOne
    @JoinColumn(nullable = false)
    private Disciplina disciplina;

    @Column(name = "dia_da_semana")
    private String diaDaSemana;

    @Column(name = "hora_inicio")
    private String horaInicio;

    @Column(name = "hora_fim")
    private String horaFim;

    private boolean ativo;

    @Column(name = "data_cadastro")
    @CreationTimestamp
    private LocalDateTime dataCadastro;

    public Monitor(MonitorDTO monitor, Disciplina disciplina, Aluno aluno) {
        this.diaDaSemana = monitor.diaDaSemana();
        this.horaInicio = monitor.horaInicio();
        this.horaFim = monitor.horaFim();
        this.ativo = monitor.ativo();
        this.disciplina = disciplina;
        this.aluno = aluno;
    }
}
