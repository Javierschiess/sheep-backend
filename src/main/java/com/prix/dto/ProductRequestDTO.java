package com.prix.dto;

import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;

@Setter
@Getter
public class ProductRequestDTO {

    private String idProducto;

    private String nombre;

    private Float precio;

    private String foto;

    private String descripcion;

    private LocalDateTime fechaRegistro;

    private String idCategoria;

    private String idComercio;

    private String idEstado;

    private Integer rating;

    private String idMunicipio;


}
