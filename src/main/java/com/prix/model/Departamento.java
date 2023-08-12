package com.prix.model;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import org.hibernate.annotations.UuidGenerator;

@Entity
@Setter
@Getter
@Table(name = "departamento")
public class Departamento {

    @Id
    @UuidGenerator
    @Column(name = "id_departamento")
    private String idDepartamento;

    private String nombre;

    private String descripcion;

}
