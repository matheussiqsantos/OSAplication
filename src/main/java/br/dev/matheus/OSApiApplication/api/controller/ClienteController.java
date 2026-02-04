package br.dev.matheus.OSApiApplication.api.controller;

import br.dev.matheus.OSApiApplication.domain.model.Cliente;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import java.util.List;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.GetMapping;

@RestController
public class ClienteController {
    
    @PersistenceContext
    private EntityManager manager;
    
    @GetMapping("/clientes")
    public List<Cliente> listas() {
        
        return manager.createQuery("from Cliente", Cliente.class)
                .getResultList();
        
        
    }
}
