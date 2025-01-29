package com.primeira.appSpring.model;

import java.time.LocalDateTime;

public interface M_ViewLocacao {
    String getNome();
    Double getPreco();
    String getSenha();
    LocalDateTime getCheckIn();
    LocalDateTime getCheckOut();
    Integer getDiarias();
}
