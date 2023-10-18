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
@Table(name = "cliente")
public class Cliente {

    @Id
    //@UuidGenerator
    @Column(name = "id_cliente")
    private String idCliente;

    @Column(name = "nombres", length = 25)
    private String nombres;

    @Column(name = "apellidos", length = 50)
    private String apellidos;

    @Column(name = "correo", length = 50)
    private String email;

    @Column(name = "telefono", length = 10)
    private Integer telefono;

    @CurrentTimestamp
    @Column(name = "fecha_registro", length = 50)
    private LocalDateTime fechaRegistro;

    @Column(name = "contraseña", length = 75)
    private String password;

    @ManyToOne
    @JoinColumn(name = "id_municipio", foreignKey = @ForeignKey(name = "FK_cliente_municipio"))
    private Municipio municipio;


}
