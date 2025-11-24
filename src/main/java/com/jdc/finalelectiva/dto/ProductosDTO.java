package com.jdc.finalelectiva.dto;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class ProductosDTO {
    private Integer idproducto;
    private String nombre;
    private String categoria;
    private float precio;
    private String unidad;
    private boolean activo;

    public ProductosDTO(){

    }
}
