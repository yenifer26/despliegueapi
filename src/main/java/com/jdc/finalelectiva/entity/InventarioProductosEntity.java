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
@Table(name = "inventario_productos")
public class InventarioProductosEntity implements Serializable {

    @Serial
    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_inventario_producto")
    private Integer idinventarioproducto;

    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "fk_producto", referencedColumnName = "id_producto")
    @OnDelete(action = OnDeleteAction.CASCADE) //No se deben eliminar los resgistros, se hace solo para el ejemplo
    private ProductosEntity fkproducto;

    @Column(name = "cantidad")
    private float cantidad;
}
