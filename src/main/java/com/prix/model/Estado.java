package com.prix.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.Setter;
import org.hibernate.annotations.UuidGenerator;

@Entity
@Setter
@Getter
@Table(name = "estado")
public class Estado {

    @Id
    @UuidGenerator
    @Column(name = "id_estado")
    private String idEstado;

    @Column(name = "nombre",length = 50, nullable = false)
    private String nombre;
}
