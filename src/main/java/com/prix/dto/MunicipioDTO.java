package com.prix.dto;

import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
public class MunicipioDTO {

    private String idMunicipio;

    private String nombre;

    private String descripcion;

    private DepartamentoDTO departamento;
}
