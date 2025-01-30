package com.primeira.appSpring.controller;

import com.primeira.appSpring.service.S_Quarto;
import jakarta.servlet.http.HttpSession;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class C_Quarto {
    private final S_Quarto s_quarto;

    public C_Quarto(S_Quarto s_quarto) {
        this.s_quarto = s_quarto;
    }

    @PostMapping("/getQuartosDisponiveis")
    public String getQuartosDisponiveis(@RequestParam("checkin") String checkin,
                                        @RequestParam("checkout") String checkout,
                                        HttpSession session,
                                        Model model) {
        if(session.getAttribute("usuario") != null){
            model.addAttribute("quartos", this.s_quarto.getQuartosDisponiveis(checkin,checkout));
            return "cadastro/pv/selectListaQuartos";
        }
        return "redirect:/";
    }
}
