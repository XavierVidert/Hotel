package com.primeira.appSpring.service;

import com.primeira.appSpring.model.M_Usuario;
import com.primeira.appSpring.repository.R_Usuario;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class S_Cadastro {
    @Autowired
    private R_Usuario r_usuario;

    public S_Cadastro(R_Usuario r_usuario) {
        this.r_usuario = r_usuario;
    }

    public M_Usuario cadastrarUsuario(String usuario,
                                      String email,
                                      String senha,
                                      String conf_senha){
        boolean podeSalvar = true;

        if (senha == null || !senha.trim().equals(conf_senha)){
            podeSalvar = false;
        }
        if(usuario.trim().equals("") || usuario == null){
            podeSalvar = false;
        }
        if(email.trim().equals("") || email == null){
            podeSalvar = false;
        }

        if(podeSalvar){
            M_Usuario m_usuario = new M_Usuario();
            m_usuario.setUsuario(usuario);
            m_usuario.setEmail(email);
            m_usuario.setSenha(senha);
            return r_usuario.save(m_usuario);
        }
        return null;
    }
}