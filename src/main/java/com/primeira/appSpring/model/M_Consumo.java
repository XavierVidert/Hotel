package com.primeira.appSpring.model;

import jakarta.persistence.*;

import java.time.LocalDateTime;

@Entity
@Table(name = "consumo")
public class M_Consumo {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @ManyToOne
    @JoinColumn(name = "id_locacao", nullable = false)
    private M_Locacao locacao;
    @ManyToOne
    @JoinColumn(name = "id_produto", nullable = false)
    private M_Produto produto;
    private Integer quantidade;
    private Double preco;
    private LocalDateTime data;

    public Long getId() {
        return this.id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public com.primeira.appSpring.model.M_Locacao getLocacao() {
        return locacao;
    }

    public void setLocacao(com.primeira.appSpring.model.M_Locacao locacao) {
        this.locacao = locacao;
    }

    public com.primeira.appSpring.model.M_Produto getProduto() {
        return produto;
    }

    public void setProduto(com.primeira.appSpring.model.M_Produto produto) {
        this.produto = produto;
    }

    public Integer getQuantidade() {
        return quantidade;
    }

    public void setQuantidade(Integer quantidade) {
        this.quantidade = quantidade;
    }

    public Double getPreco() {
        return preco;
    }

    public void setPreco(Double preco) {
        this.preco = preco;
    }

    public LocalDateTime getData() {
        return data;
    }

    public void setData(LocalDateTime data) {
        this.data = data;
    }
}
