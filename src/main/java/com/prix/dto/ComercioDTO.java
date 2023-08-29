package com.prix.dto;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Setter
@Getter
@ToString
public class ComercioDTO {

    private String idComercio;

    private String nombre;

    private String direccion;

    private String nit;

    private String email;

    private String username;

    private String password;

    private MunicipioDTO municipio;

}
