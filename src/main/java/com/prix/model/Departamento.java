package com.prix.model;

import jakarta.persistence.*;
import lombok.*;
import org.hibernate.annotations.UuidGenerator;

import java.util.List;

@Entity
@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "departamento")
public class Departamento {

    @Id
    @UuidGenerator
    @Column(name = "id_departamento")
    private String idDepartamento;

    @Column(name = "nombre", length = 50, nullable = false)
    private String nombre;

    @Column(name = "descripcion", length = 150)
    private String descripcion;

    @OneToMany(mappedBy = "departamento", cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    private List<Municipio> municipios;

}
