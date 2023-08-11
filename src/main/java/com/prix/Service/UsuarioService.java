package com.prix.Service;

import com.prix.model.Usuario;
import com.prix.repo.IGenericRepo;
import com.prix.repo.IUsuarioRepo;
import org.springframework.stereotype.Service;

@Service
public class UsuarioService extends CRUDImpl<Usuario, Integer> {

    private final IUsuarioRepo repo;

    public UsuarioService(IUsuarioRepo repo) {
        this.repo = repo;
    }

    @Override
    protected IGenericRepo<Usuario, Integer> getRepo() {
        return repo;
    }
}
