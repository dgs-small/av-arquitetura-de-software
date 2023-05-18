package com.monitor.monitor.model.dto;

public record MonitorDTO(
        AlunoDTO aluno,
        DisciplinaDTO disciplina,
        String diaDaSemana,
        String horaInicio,
        String horaFim,
        boolean ativo
) { }
