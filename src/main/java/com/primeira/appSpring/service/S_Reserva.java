package com.primeira.appSpring.service;

import com.primeira.appSpring.model.M_Locacao;
import com.primeira.appSpring.model.M_Quarto;
import com.primeira.appSpring.repository.R_Locacao;
import com.primeira.appSpring.repository.R_Quarto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.Random;

@Service
public class S_Reserva {
    @Autowired
    private R_Locacao r_locacao;
    @Autowired
    private R_Quarto r_quarto;

    public M_Locacao realizarReserva(String checkin, String checkout,
                                     Long quarto, Long usuario){
        M_Quarto m_quarto = this.r_quarto.findById(quarto).orElse(null);

        M_Locacao m_locacao = new M_Locacao();
        m_locacao.setCheckIn(LocalDateTime.parse(
                LocalDate.parse(checkin).atTime(14,0,0).toString()));
        m_locacao.setCheckOut(LocalDateTime.parse(
                LocalDate.parse(checkout).atTime(10,0,0).toString()));
        m_locacao.setIdUsuario(usuario);
        m_locacao.setIdQuarto(quarto);
        m_locacao.setPreco(m_quarto.getPreco());
        Random rand = new Random();
        m_locacao.setSenha(String.valueOf(rand.nextInt(1000,10000)));

        return r_locacao.save(m_locacao);
    }
}
