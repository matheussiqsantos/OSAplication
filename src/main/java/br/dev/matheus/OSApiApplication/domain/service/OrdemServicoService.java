package br.dev.matheus.OSApiApplication.domain.service;

import br.dev.matheus.OSApiApplication.domain.model.Cliente;
import br.dev.matheus.OSApiApplication.domain.model.OrdemServico;
import br.dev.matheus.OSApiApplication.domain.model.StatusOrdemServico;
import br.dev.matheus.OSApiApplication.domain.repository.ClienteRepository;
import br.dev.matheus.OSApiApplication.domain.repository.OrdemServicoRepository;
import java.time.LocalDateTime;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class OrdemServicoService {

    @Autowired
    private OrdemServicoRepository ordemServicoRepository;

    @Autowired
    private ClienteRepository clienteRepository;

    public OrdemServico criar(OrdemServico ordemServico) {

        Cliente cliente = clienteRepository.findById(ordemServico.getCliente().getId())
                .orElseThrow(() -> new RuntimeException("Cliente não encontrado"));

        ordemServico.setCliente(cliente);

        ordemServico.setStatus(StatusOrdemServico.ABERTA);
        ordemServico.setDataAbertura(LocalDateTime.now());

        return ordemServicoRepository.save(ordemServico);
    }

    public OrdemServico salvar(OrdemServico ordemServico) {

        OrdemServico ordemAtual = ordemServicoRepository.findById(ordemServico.getId())
                .orElseThrow(() -> new RuntimeException("Ordem não encontrada"));

        Long clienteId = ordemServico.getCliente().getId();

        Cliente cliente = clienteRepository.findById(clienteId)
                .orElseThrow(() -> new RuntimeException("Cliente não encontrado"));

        ordemAtual.setCliente(cliente);
        ordemAtual.setDescricao(ordemServico.getDescricao());
        ordemAtual.setPreco(ordemServico.getPreco());

        return ordemServicoRepository.save(ordemAtual);
    }

    public void excluir(Long ordemServicoID) {

        ordemServicoRepository.deleteById(ordemServicoID);
    }

    public List<OrdemServico> listarPorCliente(Long clienteId) {

        return ordemServicoRepository.findByClienteId(clienteId);
    }

}
