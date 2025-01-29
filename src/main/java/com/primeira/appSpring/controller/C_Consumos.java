package com.primeira.appSpring.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class C_Consumos {
    @GetMapping("/consumo")
    public String getConsumos(){
        return "consumos/consumo";
    }

    @PostMapping("/item-consumo")
    public String getItemConsumo(){
        return "consumos/item";
    }
}