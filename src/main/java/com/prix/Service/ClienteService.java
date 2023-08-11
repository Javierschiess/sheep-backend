package com.prix.Service;

import com.prix.model.Cliente;
import com.prix.repo.IClienteRepo;
import com.prix.repo.IGenericRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;

@Service
public class ClienteService extends CRUDImpl<Cliente, Integer> {

    @Autowired
    private IClienteRepo repo;
    @Override
    protected IGenericRepo<Cliente, Integer> getRepo() {
        return repo;
    }

    public Cliente registrarCliente(Cliente cliente)throws Exception{
        cliente.setFechaRegistro(LocalDateTime.now());
        return repo.save(cliente);
    }

}
