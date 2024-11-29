package com.primeira.appSpring.controller;

import jakarta.servlet.http.HttpSession;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class C_Reserva {
    @PostMapping("/reservar")
    @ResponseBody
    public Boolean realizarReserva(@RequestParam("checkin") String checkin,
                                   @RequestParam("checkout") String checkout,
                                   @RequestParam("quarto") int quarto,
                                   HttpSession session){
        return false;
    }
}
