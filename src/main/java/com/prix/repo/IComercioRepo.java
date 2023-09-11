package com.prix.repo;

import com.prix.model.Comercio;
import org.springframework.data.jpa.repository.Query;

public interface IComercioRepo extends IGenericRepo<Comercio, String> {

    @Query(value = "SELECT COUNT(*) FROM Comercio ", nativeQuery = true)
    long totalComercios();

    @Query(value = " SELECT COUNT (*) FROM Comercio c WHERE c.fecha_registro >= CURRENT_TIMESTAMP  - INTERVAL '1 day'", nativeQuery = true)
    long totalComercios24();
}
