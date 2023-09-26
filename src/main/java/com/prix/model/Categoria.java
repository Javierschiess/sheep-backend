package com.prix.model;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import org.hibernate.annotations.CurrentTimestamp;
import org.hibernate.annotations.UuidGenerator;

import java.time.LocalDateTime;

@Entity
@Setter
@Getter
@Table(name = "categoria")
public class Categoria {

    @Id
    @UuidGenerator
    @Column(name = "id_categoria")
    private String idCategoria;

    @Column(name = "nombre", length = 25, nullable = false)
    private String nombre;

    @Column(name = "descripcion", length = 150)
    private String descripcion;

    @CurrentTimestamp
    @Column(name = "fecha_registro")
    private LocalDateTime fechaRegistro;
}
