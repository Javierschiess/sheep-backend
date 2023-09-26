package com.prix.model;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import org.hibernate.annotations.UuidGenerator;
import org.springframework.security.config.annotation.method.configuration.EnableMethodSecurity;

import java.time.LocalDateTime;
import java.util.List;

@Entity
@Setter
@Getter
@Table(name = "comercio")
@ToString
public class Comercio {

    @Id
    //@UuidGenerator
    @Column(name = "id_comercio", nullable = false)
    private String idComercio;

    @Column(name = "nombre", length = 75)
    private String nombre;

    @Column(name = "direccion", length = 75)
    private String direccion;

    @Column(name = "nit", length = 15)
    private String nit;

    @Column(name = "correo", length = 50)
    private String email;

    @Column(name = "usuario",nullable = false,  length = 70)
    private String username;

    @Column(name = "contraseña", nullable = false, length = 75)
    private String password;

    @Column(name = "fecha_registro", length = 50)
    private LocalDateTime fechaRegistro;

    @Column(name = "categoria", length = 50)
    private String categoria;

    @Column(name = "municipio", length = 50)
    private String municipio;

}
