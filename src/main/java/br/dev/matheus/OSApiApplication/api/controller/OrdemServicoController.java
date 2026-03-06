package br.dev.matheus.OSApiApplication.api.controller;

import br.dev.matheus.OSApiApplication.domain.model.OrdemServico;
import br.dev.matheus.OSApiApplication.domain.repository.OrdemServicoRepository;
import br.dev.matheus.OSApiApplication.domain.service.OrdemServicoService;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/ordem-servico")
public class OrdemServicoController {

    @Autowired
    private OrdemServicoService ordemServicoService;
    
    @Autowired
    private OrdemServicoRepository ordemServicoRepository;
    
  

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public OrdemServico criar(@RequestBody OrdemServico ordemServico) {
            return ordemServicoService.criar(ordemServico);
    }
    
    @GetMapping
    public List<OrdemServico> listas() {
        
        return ordemServicoRepository.findAll();
    }
    
    @GetMapping("/{ordemServicoID}")  
    public ResponseEntity<OrdemServico> buscar(@PathVariable Long ordemServicoID) {
        
        Optional<OrdemServico> ordemServico = ordemServicoRepository.findById(ordemServicoID);
        
        if (ordemServico.isPresent()) {
            return ResponseEntity.ok(ordemServico.get());
        } else {
            return ResponseEntity.notFound().build();
        }
    }
    
    @GetMapping("/por-cliente/{clienteId}")
    public ResponseEntity<List<OrdemServico>> listar(@PathVariable Long clienteId) {
       
       List<OrdemServico> ordensDoUsuario = ordemServicoService.listarPorCliente(clienteId);
       
       if (ordensDoUsuario.isEmpty()) {
           return ResponseEntity.notFound().build();
       } else {
           return ResponseEntity.ok(ordensDoUsuario);
       }
       
    }
    
    @PutMapping("/{ordemServicoID}")
    public ResponseEntity<OrdemServico> atualizar(@PathVariable Long ordemServicoID,
                                                    @RequestBody OrdemServico ordemServico) {
        if (!ordemServicoRepository.existsById(ordemServicoID)) {
            return ResponseEntity.notFound().build();
        }
        
        ordemServico.setId(ordemServicoID);
        ordemServico = ordemServicoService.salvar(ordemServico);
        return ResponseEntity.ok(ordemServico);
        
    }
    
    @DeleteMapping("/{ordemServicoID}")
    public ResponseEntity<Void> excluir(@PathVariable Long ordemServicoID) {
        
        if (!ordemServicoRepository.existsById(ordemServicoID)) {
            return ResponseEntity.notFound().build();
        }
        
        ordemServicoService.excluir(ordemServicoID);
        return ResponseEntity.noContent().build();
    }
}
