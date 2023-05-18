package com.monitor.monitor.controller;

import com.monitor.monitor.model.domain.Aluno;
import com.monitor.monitor.model.dto.AlunoDTO;
import com.monitor.monitor.service.AlunoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/aluno")
public class AlunoController {

    @Autowired
    private AlunoService alunoService;

    @PostMapping("/add-all")
    public ResponseEntity<List<Aluno>> adicionar(@RequestBody List<AlunoDTO> alunos) {
        return new ResponseEntity<>(alunoService.saveAll(alunos), HttpStatus.CREATED);
    }

    @DeleteMapping("/{id}")
    public HttpStatus remover(@PathVariable Long id) {
        alunoService.deleteById(id);
        return HttpStatus.OK;
    }

    @PutMapping("/{id}")
    public ResponseEntity<Aluno> atualizar(@RequestBody AlunoDTO aluno, @PathVariable Long id) {
        return new ResponseEntity<>(alunoService.update(aluno, id), HttpStatus.OK);
    }
}
