package com.prix.model;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import org.hibernate.annotations.UuidGenerator;

import java.time.LocalDateTime;

@Entity
@Setter
@Getter
@Table(name = "producto")
@ToString
public class Producto {

    @Id
    @UuidGenerator
    @Column(name = "id_producto")
    private String idProducto;

    private String nombre;

    private Float precio;

    private String foto;

    private String descripcion;

    private LocalDateTime fechaRegistro;

    private String categoria;

    private Integer rating;

    @ManyToOne
    @JoinColumn(name = "id_comercio",  foreignKey = @ForeignKey(name = "FK_producto_comerio"))
    private Comercio comercio;

    @ManyToOne
    @JoinColumn(name = "id_municipio", foreignKey = @ForeignKey(name = "FK_producto_municipio"))
    private Municipio municipio;

    private String estado;



}
