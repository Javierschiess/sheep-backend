package com.prix.dto;

import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
public class ComercioDTO {

    private String idComercio;

    private String nombre;

    private String direccion;

    private CategoriaDTO categoria;

    private MunicipioDTO municipio;
}
