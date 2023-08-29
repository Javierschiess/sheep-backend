package com.prix.dto;

import com.fasterxml.jackson.annotation.JsonManagedReference;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Setter
@Getter
public class DepartamentoDTO {

    private String idDepartamento;

    private String nombre;

    private String descripcion;

    @JsonManagedReference
    protected List<MunicipioDTO> municipios;

}
