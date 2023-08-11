package com.prix.model;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Entity
@Setter
@Getter
@Table(name = "menu")
public class Menu {

    @Id
    @Column(name = "id_menu")
    private Integer idMenu;

    private String icono;

    private String nombre;

    private String url;

    @OneToMany(fetch = FetchType.EAGER)
    @JoinTable(name = "menu_rol", joinColumns = @JoinColumn(name = "id_menu", referencedColumnName = "id_menu"),
                inverseJoinColumns = @JoinColumn(name = "id_rol", referencedColumnName = "id_rol"))
    private List<Rol> roles;


}
