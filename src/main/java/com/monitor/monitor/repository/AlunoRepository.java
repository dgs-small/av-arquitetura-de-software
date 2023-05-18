package com.monitor.monitor.repository;

import com.monitor.monitor.model.domain.Aluno;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AlunoRepository extends JpaRepository<Aluno, Long> { }
