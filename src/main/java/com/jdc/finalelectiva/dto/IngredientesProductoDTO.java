package com.jdc.finalelectiva.dto;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class IngredientesProductoDTO {
    private Integer idingredienteproducto;
    private Integer fkproducto;
    private Integer fkingredient;
    private float cantidad;

    public IngredientesProductoDTO(){

    }
}
