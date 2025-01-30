package com.primeira.appSpring.controller;

import com.primeira.appSpring.service.S_Produto;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class C_Consumos {
    private final S_Produto s_produto;

    public C_Consumos(S_Produto s_produto) {
        this.s_produto = s_produto;
    }

    @GetMapping("/consumo")
    public String getConsumos(Model model){
        model.addAttribute("produtos", s_produto.getProdutos());
        return "consumos/consumo";
    }

    @PostMapping("/item-consumo")
    public String getItemConsumo(){
        return "consumos/item";
    }
}