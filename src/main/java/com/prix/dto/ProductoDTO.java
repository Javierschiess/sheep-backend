package com.prix.dto;

import lombok.Getter;
import lombok.Setter;
import org.springframework.scheduling.support.SimpleTriggerContext;

import java.time.LocalDateTime;

@Setter
@Getter
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

    private String idUser;

}
