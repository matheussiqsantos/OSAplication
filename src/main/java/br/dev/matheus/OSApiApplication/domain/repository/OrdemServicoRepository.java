
package br.dev.matheus.OSApiApplication.domain.repository;

import br.dev.matheus.OSApiApplication.domain.model.OrdemServico;
import org.springframework.data.jpa.repository.JpaRepository;


public interface OrdemServicoRepository extends JpaRepository<OrdemServico, Long>{
    
    
}
