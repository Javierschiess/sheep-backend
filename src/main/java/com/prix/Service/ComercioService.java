package com.prix.Service;

import com.prix.model.Comercio;
import com.prix.repo.IComercioRepo;
import com.prix.repo.IGenericRepo;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;

@Service
public class ComercioService extends CRUDImpl<Comercio, String> {

    private final IComercioRepo repo;

    public ComercioService(IComercioRepo repo) {
        this.repo = repo;
    }

    @Override
    protected IGenericRepo<Comercio, String> getRepo() {
        return repo;
    }

    public Comercio registrarComercio(Comercio comercio)throws Exception{
        comercio.setFechaRegistro(LocalDateTime.now());
        return repo.save(comercio);
    }

}
