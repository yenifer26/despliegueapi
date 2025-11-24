package com.jdc.finalelectiva.dto;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class InventarioIngredientesDTO {
    private Integer idinventarioingrediente;
    private Integer fkingrediente;
    private float cantidad;

    public InventarioIngredientesDTO(){

    }
}
