package br.dev.matheus.OSApiApplication.domain.dto;

import br.dev.matheus.OSApiApplication.domain.model.StatusOrdemServico;
import jakarta.validation.constraints.NotNull;

public record AtualizaStatusDTO(
    
    @NotNull(message = "Status é obrigatório")
    StatusOrdemServico status
    
        
) {}

