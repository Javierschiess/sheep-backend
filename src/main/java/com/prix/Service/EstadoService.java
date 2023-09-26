package com.prix.Service;

import com.prix.model.Estado;
import com.prix.repo.IEstadoRepo;
import com.prix.repo.IGenericRepo;
import org.springframework.stereotype.Service;

@Service
public class EstadoService extends CRUDImpl<Estado, String> {

    private final IEstadoRepo repo;

    public EstadoService(IEstadoRepo repo) {
        this.repo = repo;
    }

    @Override
    protected IGenericRepo<Estado, String> getRepo() {
        return repo;
    }

    public Estado registrarEstado(Estado estado)throws Exception{
        return repo.save(estado);
    }
}
