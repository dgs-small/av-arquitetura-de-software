package com.monitor.monitor.repository;

import com.monitor.monitor.model.domain.Disciplina;
import org.springframework.data.jpa.repository.JpaRepository;

public interface DisciplinaRepository extends JpaRepository<Disciplina, Long> {
    Disciplina findBySigla(String sigla);
}
