package com.jdc.finalelectiva.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;

import java.io.Serial;
import java.io.Serializable;

@Getter
@Setter
@Entity
@Table(name = "detalle_venta")
public class DetalleVentaEntity implements Serializable {

    @Serial
    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_detalle_venta")
    private Integer iddetalle;

    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "fk_venta", referencedColumnName = "id_venta")
    @OnDelete(action = OnDeleteAction.CASCADE) //No se deben eliminar los resgistros, se hace solo para el ejemplo
    private VentasEntity fkventa;

    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "fk_producto", referencedColumnName = "id_producto")
    @OnDelete(action = OnDeleteAction.CASCADE) //No se deben eliminar los resgistros, se hace solo para el ejemplo
    private ProductosEntity fkproducto;

    @Column(name = "cantidad")
    private Integer cantidad;

    @Column(name = "subtotal")
    private float subtotal;
}
