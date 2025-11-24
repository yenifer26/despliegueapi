package com.jdc.finalelectiva.dto;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class DetalleVentaDTO {
    private Integer iddetalle;
    private Integer fkventa;
    private Integer fkproducto;
    private Integer cantidad;
    private float subtotal;

    public DetalleVentaDTO() {
    }
}
