package com.prix.repo;

import com.prix.model.Cliente;
import org.springframework.data.jpa.repository.Query;


public interface IClienteRepo extends IGenericRepo<Cliente, String> {

@Query(value =" SELECT COUNT (*) FROM Cliente ", nativeQuery = true)
    long totalClientes();

@Query(value = "SELECT COUNT (*) FROM Cliente c WHERE  c.fecha_registro >= CURRENT_TIMESTAMP - INTERVAL '1 day'", nativeQuery = true)
    long totalClientes24();

}
