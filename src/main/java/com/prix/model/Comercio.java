package com.prix.model;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import org.hibernate.annotations.UuidGenerator;

import java.time.LocalDateTime;

@Entity
@Setter
@Getter
@Table(name = "comercio")
public class Comercio {

    @Id
    //@UuidGenerator
    @Column(name = "id_comercio")
    private String idComercio;

    private String nombre;

    private String direccion;

    private String nit;

    private String email;

    private String username;

    private String password;

    private LocalDateTime fechaRegistro;

    private String categoria;


/*
    @ManyToOne
    @JoinColumn(name = "id_municipio", nullable = false, foreignKey = @ForeignKey(name = "FK_comercio_municipio"))
    private Municipio municipio;
*/


}
