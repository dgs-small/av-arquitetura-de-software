package com.monitor.monitor.service;

import com.monitor.monitor.model.domain.Disciplina;
import com.monitor.monitor.model.dto.DisciplinaDTO;
import com.monitor.monitor.repository.DisciplinaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class DisciplinaService {

    @Autowired
    DisciplinaRepository disciplinaRepository;

    public Disciplina save(DisciplinaDTO disciplina) {
        return disciplinaRepository.save(new Disciplina(disciplina));
    }

}
