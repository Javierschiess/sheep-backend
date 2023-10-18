package com.prix.model;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.CurrentTimestamp;
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

    @Column(name = "nombre", length = 50)
    private String nombre;

    @Column(name = "precio", length = 10)
    private Float precio;

    @Column(name = "foto", length = 150)
    private String foto;

    @Column(name = "descripcion", length = 150)
    private String descripcion;

    @CreationTimestamp
    @Column(name = "fecha_registro", length = 15)
    private LocalDateTime fechaRegistro;

    @Column(name = "clasificacion", length = 25)
    private Integer rating;

    @Column(name = "municipio", length = 50)
    private String municipio;

    @ManyToOne
    @JoinColumn(name = "id_Categoria", foreignKey = @ForeignKey(name = "FK_producto_categoria"))
    private Categoria categoria;

    @ManyToOne
    @JoinColumn(name = "id_comercio",  foreignKey = @ForeignKey(name = "FK_producto_comerio"))
    private Comercio comercio;

    @ManyToOne
    @JoinColumn(name = "id_estado", foreignKey = @ForeignKey(name = "FK_producto_estado"))
    private Estado estado;

}
