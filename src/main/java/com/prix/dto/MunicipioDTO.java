package com.prix.dto;

import com.fasterxml.jackson.annotation.JsonBackReference;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Setter
@Getter
@ToString
public class MunicipioDTO {

    private String idMunicipio;

    private String nombre;

    private String descripcion;

    @JsonBackReference
    private DepartamentoDTO departamento;
}
