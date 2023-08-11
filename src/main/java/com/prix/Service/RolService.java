package com.prix.Service;

import com.prix.model.Rol;
import com.prix.repo.IGenericRepo;
import com.prix.repo.IRolRepo;

public class RolService extends CRUDImpl<Rol, Integer> {

    private final IRolRepo repo;

    public RolService(IRolRepo repo) {
        this.repo = repo;
    }

    @Override
    protected IGenericRepo<Rol, Integer> getRepo() {
        return repo;
    }
}
