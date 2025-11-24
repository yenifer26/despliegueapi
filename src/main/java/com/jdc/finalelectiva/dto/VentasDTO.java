package com.jdc.finalelectiva.dto;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class VentasDTO {
    private Integer idventa;
    private Integer fkusuario;
    private String fecha;
    private float total;

    public VentasDTO() {

    }
}
