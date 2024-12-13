package com.primeira.appSpring.model;

import jakarta.persistence.*;

import java.time.LocalDateTime;

@Entity
@Table(name = "locacao")
public class M_Locacao {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private LocalDateTime checkIn;
    private LocalDateTime checkOut;
    private String senha;
    private Double preco;

    @ManyToOne
    @JoinColumn(name = "id_usuario", nullable = false)
    private M_Usuario usuario;

    @ManyToOne
    @JoinColumn(name = "id_quarto", nullable = false)
    private M_Quarto quarto;

    // Getters e Setters
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public LocalDateTime getCheckIn() {
        return checkIn;
    }

    public void setCheckIn(LocalDateTime checkIn) {
        this.checkIn = checkIn;
    }

    public LocalDateTime getCheckOut() {
        return checkOut;
    }

    public void setCheckOut(LocalDateTime checkOut) {
        this.checkOut = checkOut;
    }

    public String getSenha() {
        return senha;
    }

    public void setSenha(String senha) {
        this.senha = senha;
    }

    public Double getPreco() {
        return preco;
    }

    public void setPreco(Double preco) {
        this.preco = preco;
    }

    public M_Usuario getUsuario() {
        return usuario;
    }

    public void setUsuario(M_Usuario usuario) {
        this.usuario = usuario;
    }

    public M_Quarto getQuarto() {
        return quarto;
    }

    public void setQuarto(M_Quarto quarto) {
        this.quarto = quarto;
    }
}
