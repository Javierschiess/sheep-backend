package com.prix.model;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.time.LocalDateTime;

@Entity
@Setter
@Getter
@Table(name = "comercio")
@ToString
public class Comercio {

    @Id
    //@UuidGenerator
    @Column(name = "id_comercio")
    private String idComercio;

    @Column(name = "nombre", length = 75)
    private String nombre;

    @Column(name = "direccion", length = 75)
    private String direccion;

    @Column(name = "nit", length = 15)
    private String nit;

    @Column(name = "correo", length = 50)
    private String email;

    @Column(name = "usuario", length = 70)
    private String username;

    @Column(name = "contraseña", length = 75)
    private String password;

    @Column(name = "fecha_registro", length = 50)
    private LocalDateTime fechaRegistro;

    @Column(name = "categoria", length = 50)
    private String categoria;

    @Column(name = "municipio", length = 50)
    private String municipio;

}
