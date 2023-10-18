package com.prix.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.Data;

@Entity
@Data
public class Imagen {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    private String name;

    private String imagenUrl;

    private String imagenId;


    public Imagen( String name, String imagenUrl, String imagenId) {
        this.name = name;
        this.imagenUrl = imagenUrl;
        this.imagenId = imagenId;
    }

    public Imagen() {

    }
}
