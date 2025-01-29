package com.primeira.appSpring.service;

import com.primeira.appSpring.model.M_Quarto;
import com.primeira.appSpring.repository.R_Quarto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class S_Quarto {
    @Autowired
    private R_Quarto r_quarto;

    public List<M_Quarto> getQuartosDisponiveis(String checkIn, String checkOut){
        return r_quarto.getQuartosDisponiveisPeriodo(checkIn+" 14:00",checkOut+" 10:00");
    }
}
