package com.monitor.monitor.service;

import com.monitor.monitor.model.domain.Aluno;
import com.monitor.monitor.model.dto.AlunoDTO;
import com.monitor.monitor.repository.AlunoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class AlunoService {

    @Autowired
    private AlunoRepository alunoRepository;

    public Aluno save(AlunoDTO aluno) {
        return alunoRepository.save(new Aluno(aluno));
    }

    public List<Aluno> saveAll(List<AlunoDTO> alunos) {
        List<Aluno> alunosDomain = new ArrayList<>();
        for (AlunoDTO aluno: alunos) {
            alunosDomain.add(new Aluno(aluno));
        }
        return alunoRepository.saveAll(alunosDomain);
    }

    public Aluno update(AlunoDTO aluno, Long id) {
        Aluno alunoBanco = alunoRepository.findById(id).orElseThrow(() -> new RuntimeException("Aluno não encontrado"));
        alunoBanco.setNome(aluno.nome());
        alunoBanco.setAtivo(aluno.ativo());
        return alunoRepository.save(alunoBanco);
    }

    public void deleteById(Long id) {
        alunoRepository.deleteById(id);
    }

    public Optional<Aluno> findById(Long id) {
        return alunoRepository.findById(id);
    }

}
