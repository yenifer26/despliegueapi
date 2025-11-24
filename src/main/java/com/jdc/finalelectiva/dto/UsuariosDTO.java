package com.jdc.finalelectiva.dto;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class UsuariosDTO {
    private Integer idusuario;
    private String nombre;
    private String email;
    private String rol; //'admin','vendedor','inventario'
    private boolean activo;
    private String fechacreacion;
}
