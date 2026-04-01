package br.dev.matheus.OSApiApplication.domain.model;

import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

@Entity
public class OrdemServico {

    @Schema(description = "ID único da Ordem de Serviço", example = "1")
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Schema(description = "Cliente associado à ordem de serviço")
    @ManyToOne
    private Cliente cliente;

    @Schema(description = "Descrição detalhada do problema ou serviço", example = "Troca de tela de notebook Dell")
    private String descricao;

    @Schema(description = "Preço do serviço", example = "250.00")
    private BigDecimal preco;

    @Schema(description = "Lista de comentários registrados na ordem de serviço", accessMode = Schema.AccessMode.READ_ONLY)
    @OneToMany(mappedBy = "ordemServico")
    private List<Comentario> comentarios = new ArrayList<>();

    @Schema(description = "Status atual da ordem", example = "ABERTA")
    @Enumerated(EnumType.STRING)
    private StatusOrdemServico status;

    @Schema(description = "Data e hora de abertura", example = "2024-05-20T10:30:00", accessMode = Schema.AccessMode.READ_ONLY)
    private LocalDateTime dataAbertura;

    @Schema(description = "Data e hora de finalização", example = "2024-05-21T15:00:00", accessMode = Schema.AccessMode.READ_ONLY)
    private LocalDateTime dataFinalizacao;
    
    public OrdemServico() {
    }

    public OrdemServico(Cliente cliente, String descricao, BigDecimal preco) {
        this.cliente = cliente;
        this.descricao = descricao;
        this.preco = preco;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Cliente getCliente() {
        return cliente;
    }

    public void setCliente(Cliente cliente) {
        this.cliente = cliente;
    }

    public String getDescricao() {
        return descricao;
    }

    @Override
    public int hashCode() {
        int hash = 3;
        hash = 67 * hash + Objects.hashCode(this.id);
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final OrdemServico other = (OrdemServico) obj;
        return Objects.equals(this.id, other.id);
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public BigDecimal getPreco() {
        return preco;
    }

    public void setPreco(BigDecimal preco) {
        this.preco = preco;
    }

    public StatusOrdemServico getStatus() {
        return status;
    }

    public void setStatus(StatusOrdemServico status) {
        this.status = status;
    }

    public LocalDateTime getDataAbertura() {
        return dataAbertura;
    }

    public void setDataAbertura(LocalDateTime dataAbertura) {
        this.dataAbertura = dataAbertura;
    }

    public LocalDateTime getDataFinalizacao() {
        return dataFinalizacao;
    }

    public void setDataFinalizacao(LocalDateTime dataFinalizacao) {
        this.dataFinalizacao = dataFinalizacao;
    }
    
    
}