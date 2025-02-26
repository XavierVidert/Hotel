package com.primeira.appSpring.model;

import jakarta.persistence.*;

@Entity
@Table(name="usuario",
        uniqueConstraints = {
            @UniqueConstraint(columnNames = {"usuario"}),
            @UniqueConstraint(columnNames = {"email"})
        })
public class M_Usuario {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(unique = true)
    private String usuario;
    @Column(unique = true)
    private String senha;
    private String email;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getUsuario() {
        return usuario;
    }

    public void setUsuario(String usuario) {
        this.usuario = usuario;
    }

    public String getSenha() {
        return senha;
    }

    public void setSenha(String senha) {
        this.senha = senha;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }
}
