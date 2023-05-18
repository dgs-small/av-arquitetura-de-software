package com.monitor.monitor.model.domain;

import com.monitor.monitor.model.dto.AlunoDTO;
import jakarta.persistence.*;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.CreationTimestamp;

import java.time.LocalDateTime;

@Entity
@Data
@NoArgsConstructor
public class Aluno {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String nome;

    private boolean ativo;

    @Column(name = "data_cadastro")
    @CreationTimestamp
    private LocalDateTime dataCadastro;

    public Aluno(AlunoDTO alunoDTO) {
        this.nome = alunoDTO.nome();
        this.ativo = alunoDTO.ativo();
    }
}
