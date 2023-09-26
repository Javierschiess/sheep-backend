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

    private CategoriaDTO categoria;

    private ComercioDTO comercio;

    private EstadoDTO estado;

    private Integer rating;

    private MunicipioDTO municipio;

}
