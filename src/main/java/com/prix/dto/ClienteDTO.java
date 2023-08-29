package com.prix.dto;

import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
public class ClienteDTO {

    private String idCliente;

    private String nombres;

    private String apellidos;

    private String email;

    private String telefono;

    private String password;

    private MunicipioDTO municipio;

}
