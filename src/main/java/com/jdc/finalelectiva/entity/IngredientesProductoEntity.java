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
@Table(name = "ingredientes_producto")
public class IngredientesProductoEntity implements Serializable {
    @Serial
    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_ingrediente_producto")
    private Integer idingredienteproducto;

    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "fk_producto", referencedColumnName = "id_producto")
    @OnDelete(action = OnDeleteAction.CASCADE) //No se deben eliminar los resgistros, se hace solo para el ejemplo
    private ProductosEntity fkproducto;

    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "fk_ingrediente", referencedColumnName = "id_ingrediente")
    @OnDelete(action = OnDeleteAction.CASCADE) //No se deben eliminar los resgistros, se hace solo para el ejemplo
    private IngredientesEntity fkingrediente;

    @Column(name = "cantidad")
    private float cantidad;

}
