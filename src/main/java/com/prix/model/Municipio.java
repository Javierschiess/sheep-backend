package com.prix.model;

import jakarta.persistence.*;
import lombok.*;
import org.hibernate.annotations.UuidGenerator;

@Entity
@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
@ToString
@Table(name = "municipio")
public class Municipio {

    @Id
    @UuidGenerator
    @Column(name = "id_municipio")
    private String idMunicipio;

    @Column(name = "nombre", length = 50, nullable = false)
    private String nombre;

    @Column(name = "descripcion", length = 150)
    private String Descripcion;

    @ManyToOne
    @JoinColumn(name = "id_departamento", nullable = false, foreignKey = @ForeignKey(name = "FK_municipio_departamento"))
    private Departamento departamento;



}
