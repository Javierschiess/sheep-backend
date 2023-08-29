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

    private String municipio;

}
