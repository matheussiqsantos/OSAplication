/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package br.dev.matheus.OSApiApplication.api.controller;

import br.dev.matheus.OSApiApplication.domain.dto.ComentarioDTO;
import br.dev.matheus.OSApiApplication.domain.model.Comentario;
import br.dev.matheus.OSApiApplication.domain.service.ComentarioService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

/**
 *
 * @author sesi3dib
 */
@RestController
public class ComentarioController {

    @Autowired
    private ComentarioService comentarioService;

    @PostMapping("/ordem-servico/{ordemServicoId}/comentar")
    @ResponseStatus(HttpStatus.CREATED)
    public Comentario adicionarComentario (
                    @PathVariable Long ordemServicoId,
                    @Valid @RequestBody ComentarioDTO comentarioInput) {

        return comentarioService.comentar(ordemServicoId, comentarioInput);
    }
}
