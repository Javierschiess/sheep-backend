package com.prix.model;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import org.hibernate.annotations.UuidGenerator;

import java.time.LocalDateTime;

@Entity
@Setter
@Getter
@Table(name = "cliente")
public class Cliente {

    @Id
    @UuidGenerator
    @Column(name = "id_cliente")
    private String idCliente;

    private String nombres;

    private String apellidos;

    private String email;

    private Integer telefono;

    private LocalDateTime fechaRegistro;

    /*
    @ManyToOne
    @JoinColumn(name = "id_municipio", nullable = false, foreignKey = @ForeignKey(name = "FK_cliente_municipio"))
    private Municipio municipio;

     */
}
