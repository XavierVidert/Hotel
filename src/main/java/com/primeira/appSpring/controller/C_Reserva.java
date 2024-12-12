package com.primeira.appSpring.controller;

import com.primeira.appSpring.model.M_Usuario;
import com.primeira.appSpring.service.S_Reserva;
import jakarta.servlet.http.HttpSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class C_Reserva {
    @Autowired
    private final S_Reserva s_reserva;

    public C_Reserva(S_Reserva s_reserva) {
        this.s_reserva = s_reserva;
    }

    @PostMapping("/reservar")
    @ResponseBody
    public Boolean realizarReserva(@RequestParam("checkin") String checkin,
                                   @RequestParam("checkout") String checkout,
                                   @RequestParam("quarto") Long quarto,
                                   HttpSession session){
        M_Usuario m_usuario = (M_Usuario) session.getAttribute("usuario");
        return this.s_reserva.realizarReserva(checkin,
                checkout,quarto,m_usuario.getId()) != null;
    }
}
