package com.prix.repo;

import com.prix.model.Producto;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface IProductoRepo extends IGenericRepo<Producto, String> {

   List<Producto> findAllByIdProducto(String idProducto);

  /* List<Producto> findAllByMunicipioIdMunicipioAndNombreContainingIgnoreCase(String idMunicipio, String nombre);*/

   List<Producto> findAllByComercioIdComercio(String idComercio);


   List<Producto> findAllByMunicipio(String idMunicipio);

   @Query(value = "SELECT COUNT (*) FROM Producto ", nativeQuery = true)
   long getAllProducto();

   @Query(value = "SELECT COUNT(*) FROM producto WHERE producto.fecha_registro >= CURRENT_TIMESTAMP - INTERVAL '1 day'", nativeQuery = true)
   long productos24();


}
