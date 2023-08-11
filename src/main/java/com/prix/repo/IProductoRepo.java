package com.prix.repo;

import com.prix.model.Producto;

import java.util.List;

public interface IProductoRepo extends IGenericRepo<Producto, String> {

   List<Producto> findAllByIdProducto(String idProducto);

   List<Producto> findAllByMunicipioIdMunicipioAndNombreContainingIgnoreCase(Integer idMunicipio, String nombre);

   //List<Producto> findAllByComercioIdComercio(Integer id);

}
