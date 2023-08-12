package com.prix.Service;

import com.prix.model.Municipio;
import com.prix.repo.IGenericRepo;
import com.prix.repo.IMunicipioRepo;
import org.springframework.stereotype.Service;

@Service
public class MunicipioService extends CRUDImpl<Municipio, String> {

    private final IMunicipioRepo repo;

    public MunicipioService(IMunicipioRepo repo) {
        this.repo = repo;
    }

    @Override
    protected IGenericRepo<Municipio, String> getRepo() {
        return repo;
    }
}
