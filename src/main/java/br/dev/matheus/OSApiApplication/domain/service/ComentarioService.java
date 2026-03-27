package br.dev.matheus.OSApiApplication.domain.service;

import br.dev.matheus.OSApiApplication.domain.dto.ComentarioDTO;
import br.dev.matheus.OSApiApplication.domain.model.Comentario;
import br.dev.matheus.OSApiApplication.domain.model.OrdemServico;
import br.dev.matheus.OSApiApplication.domain.repository.ComentarioRepository;
import br.dev.matheus.OSApiApplication.domain.repository.OrdemServicoRepository;
import java.time.LocalDateTime;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ComentarioService {
    
    @Autowired
    private OrdemServicoRepository ordemServicoRepository;
    
    @Autowired 
    private ComentarioRepository comentarioRepository;
    
    public Comentario comentar(Long ordemServicoId, ComentarioDTO comentarioInput) {
     
        
        OrdemServico ordemServico = ordemServicoRepository.findById(ordemServicoId)
                .orElseThrow(() -> new RuntimeException("Ordem não encontrada"));
                
        Comentario comentario = new Comentario();
        comentario.setOrdemServico(ordemServico);
        comentario.setDescricao(comentarioInput.descricao());
        comentario.setDataEnvio(LocalDateTime.now());

        return comentarioRepository.save(comentario);
    }
}
