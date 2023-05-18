package com.monitor.monitor.controller;

import com.monitor.monitor.model.domain.Disciplina;
import com.monitor.monitor.model.dto.DisciplinaDTO;
import com.monitor.monitor.service.DisciplinaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/disciplina")
public class DisciplinaController {

    @Autowired
    private DisciplinaService disciplinaService;

    @PostMapping
    public ResponseEntity<Disciplina> adicionar(@RequestBody DisciplinaDTO disciplina) {
        return new ResponseEntity<>(disciplinaService.save(disciplina), HttpStatus.CREATED);
    }
}
