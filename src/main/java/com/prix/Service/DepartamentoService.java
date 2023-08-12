package com.prix.Service;

import com.prix.model.Departamento;
import com.prix.repo.IDepartamentoRepo;
import com.prix.repo.IGenericRepo;
import org.springframework.stereotype.Service;

@Service
public class DepartamentoService extends CRUDImpl<Departamento, String> {

    private final IDepartamentoRepo repo;

    public DepartamentoService(IDepartamentoRepo repo) {
        this.repo = repo;
    }

    @Override
    protected IGenericRepo<Departamento, String> getRepo() {
        return repo;
    }
}
