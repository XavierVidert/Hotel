package com.primeira.appSpring.model;

import java.util.Date;

public interface M_API {
    String getNome();
    Long getQuantidade();
    Long getMin();
    Long getMax();
    Double getCusto_medio();
    Date getUltima_Compra();
}
