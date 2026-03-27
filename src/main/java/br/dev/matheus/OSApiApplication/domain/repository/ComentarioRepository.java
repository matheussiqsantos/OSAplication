package br.dev.matheus.OSApiApplication.domain.repository;

import br.dev.matheus.OSApiApplication.domain.model.Comentario;
import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 *
 * @author sesi3dib
 */
@Repository
public interface ComentarioRepository extends JpaRepository<Comentario, Long> {
      
    List<Comentario> findByOrdemServicoId(Long ordemServicoId);
}
