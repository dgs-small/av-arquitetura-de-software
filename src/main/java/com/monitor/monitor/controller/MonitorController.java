package com.monitor.monitor.controller;

import com.monitor.monitor.model.domain.Monitor;
import com.monitor.monitor.model.dto.MonitorDTO;
import com.monitor.monitor.service.AlunoService;
import com.monitor.monitor.service.MonitorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
@RequestMapping("/monitor")
public class MonitorController {

    @Autowired
    private MonitorService monitorService;

    @PostMapping
    public ResponseEntity<Monitor> adicionar(@RequestBody MonitorDTO monitor) {
        return new ResponseEntity<>(monitorService.save(monitor), HttpStatus.CREATED);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Optional<Monitor>> apresentar(@PathVariable("id") Long id) {
        return new ResponseEntity<>(monitorService.findById(id), HttpStatus.OK);
    }

    @GetMapping("monitor-por-aluno/{id}")
    public ResponseEntity<Optional<Monitor>> apresentarPorAluno(@PathVariable("id") Long alunoId) {

        return new ResponseEntity<>(monitorService.findByAlunoId(alunoId), HttpStatus.OK);
    }
}
