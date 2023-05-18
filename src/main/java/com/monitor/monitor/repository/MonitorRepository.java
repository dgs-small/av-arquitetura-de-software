package com.monitor.monitor.repository;

import com.monitor.monitor.model.domain.Monitor;
import org.springframework.data.jpa.repository.JpaRepository;

public interface MonitorRepository extends JpaRepository<Monitor, Long> {
    Monitor findMonitorByAluno_Id(Long alunoId);
}
