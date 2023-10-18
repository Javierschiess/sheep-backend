package com.prix.repo;

import com.prix.model.Imagen;

import java.util.List;

public interface ImagenRepo extends IGenericRepo<Imagen, String> {

    List<Imagen> findByOrderById();

}
