package com.prix.repo;

import com.prix.model.Producto;

import java.util.List;

public interface IProductoRepo extends IGenericRepo<Producto, String> {

   List<Producto> findAllByIdProducto(String idProducto);

   List<Producto> findAllByMunicipioIdMunicipioAndNombreContainingIgnoreCase(String idMunicipio, String nombre);

   List<Producto> findAllByComercioIdComercio(String idComercio);

}
