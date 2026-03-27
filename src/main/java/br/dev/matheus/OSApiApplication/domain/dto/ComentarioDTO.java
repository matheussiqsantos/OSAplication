package br.dev.matheus.OSApiApplication.domain.dto;

import jakarta.validation.constraints.NotBlank;

/**
 *
 * @author sesi3dib
 */
public record ComentarioDTO(@NotBlank String descricao) {

}
