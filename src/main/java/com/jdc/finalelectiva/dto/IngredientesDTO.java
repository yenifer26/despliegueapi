package com.jdc.finalelectiva.dto;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class IngredientesDTO {
    private Integer idingrediente;
    private String nombre;
    private String unidad;
    private boolean perecedero;
    private float minimo;

    public IngredientesDTO() {

    }
}
