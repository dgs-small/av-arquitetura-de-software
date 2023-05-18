package com.monitor.monitor.model.dto;

import java.util.List;

public record DisciplinaDTO(
        Long id,
        String sigla,
        String descricao,
        List<String> assuntos,
        boolean status
) { }
