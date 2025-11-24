package com.jdc.finalelectiva.dto;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class InventarioProductosDTO {
    private Integer idinventarioproducto;
    private Integer fkproducto;
    private float cantidad;

    public InventarioProductosDTO(){

    }
}
