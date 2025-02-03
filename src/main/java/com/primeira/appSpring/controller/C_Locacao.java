package com.primeira.appSpring.controller;

import com.primeira.appSpring.model.M_Resposta;
import com.primeira.appSpring.model.M_Usuario;
import com.primeira.appSpring.service.S_Reserva;
import jakarta.servlet.http.HttpSession;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import java.time.LocalDate;

@Controller
public class C_Locacao {
    private final S_Reserva s_reserva;

    public C_Locacao(S_Reserva s_reserva) {
        this.s_reserva = s_reserva;
    }

    @GetMapping("/cadLocacao")
    public String getCadLocacao(HttpSession session,
                                Model model){
        if(session.getAttribute("usuario") != null){
            LocalDate dataAtual = LocalDate.now();
            model.addAttribute("dataAtual", dataAtual);
            model.addAttribute("proximoDia", dataAtual.plusDays(1));
            return "locacao/cadastro";
        }
        return "redirect:/";
    }

    @PostMapping("/reservar")
    @ResponseBody
    public M_Resposta realizarReserva(@RequestParam("checkin") String checkin,
                                      @RequestParam("checkout") String checkout,
                                      @RequestParam("quarto") Long quarto,
                                      HttpSession session){
        M_Usuario m_usuario = (M_Usuario) session.getAttribute("usuario");
        return this.s_reserva.realizarReserva(checkin,
                checkout,quarto,m_usuario);
    }
}
