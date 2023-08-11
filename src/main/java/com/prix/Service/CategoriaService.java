package com.prix.Service;

import com.prix.model.Categoria;
import com.prix.repo.ICategoriaRepo;
import com.prix.repo.IGenericRepo;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;

@Service
public class CategoriaService extends CRUDImpl<Categoria, Integer> {

    private final ICategoriaRepo repo;

    public CategoriaService(ICategoriaRepo repo) {
        this.repo = repo;
    }

    @Override
    protected IGenericRepo<Categoria, Integer> getRepo() {
        return repo;
    }

    public Categoria registrarCategoria(Categoria categoria)throws Exception{
        categoria.setFechaRegistro(LocalDateTime.now());

        return repo.save(categoria);
    }

}
