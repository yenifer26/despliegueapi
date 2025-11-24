package com.jdc.finalelectiva.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;

import java.io.Serial;
import java.io.Serializable;
import java.time.LocalDateTime;

@Getter
@Setter
@Entity
@Table(name = "ventas")
public class VentasEntity implements Serializable {

    @Serial
    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_venta")
    private Integer idventa;

    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "fk_usuario", referencedColumnName = "id_usuario")
    @OnDelete(action = OnDeleteAction.CASCADE) //No se deben eliminar los resgistros, se hace solo para el ejemplo
    private UsuariosEntity fkusuario;

    @Column(name = "fecha")
    private String fecha;

    @Column(name = "total")
    private float total;
}
