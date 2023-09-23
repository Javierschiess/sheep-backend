package com.prix.dto;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.time.LocalDateTime;

@Setter
@Getter
@ToString
public class ProductoDTO {

    private String idProducto;

    private String nombre;

    private Float precio;

    private String foto;

    private String descripcion;

    private LocalDateTime fechaRegistro;

    private String categoria;

    private ComercioDTO comercio;

    private String estado;

    private Integer rating;

    private MunicipioDTO municipio;

}
