package com.monitor.monitor.service;
import com.monitor.monitor.model.domain.Aluno;
import com.monitor.monitor.model.domain.Disciplina;
import com.monitor.monitor.model.domain.Monitor;
import com.monitor.monitor.model.dto.MonitorDTO;
import com.monitor.monitor.repository.AlunoRepository;
import com.monitor.monitor.repository.DisciplinaRepository;
import com.monitor.monitor.repository.MonitorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class MonitorService {

    @Autowired
    MonitorRepository monitorRepository;

    @Autowired
    DisciplinaRepository disciplinaRepository;

    @Autowired
    AlunoRepository alunoRepository;

    //TODO:IMplementar
    public Monitor save(MonitorDTO monitor) {
        Monitor newMonitor = new Monitor();
        if (monitor.disciplina() != null && monitor.aluno() != null) {
            Optional<Disciplina> disciplina = disciplinaRepository.findById(monitor.disciplina().id());
            Optional<Aluno> aluno = alunoRepository.findById(monitor.aluno().id());

            if (disciplina.isPresent() && aluno.isPresent()) {
                newMonitor = new Monitor(monitor, disciplina.get(), aluno.get());
            }
        }

        return monitorRepository.save(newMonitor);
    }

    public Monitor update(Monitor monitor) {
        return monitorRepository.save(monitor);
    }

    public void deleteById(Long id) {
        monitorRepository.deleteById(id);
    }

    public Optional<Monitor> findById(Long id) {
        return monitorRepository.findById(id);
    }

    public Optional<Monitor> findByAlunoId(Long id) {
        return Optional.ofNullable(monitorRepository.findMonitorByAluno_Id(id));
    }

}
