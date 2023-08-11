package com.prix.Service;

import com.prix.repo.IGenericRepo;

import java.util.List;

public abstract class CRUDImpl<T, ID> {

    protected abstract IGenericRepo<T, ID> getRepo();

    public T registrar(T t)throws Exception{
        return getRepo().save(t);
    }
    public T modificar (T t)throws Exception{
        return getRepo().save(t);
    }

    public List<T> listar()throws Exception{
        return getRepo().findAll();
    }

    public T listarPorId(ID id)throws Exception{
        return getRepo().findById(id).orElse(null);
    }

    public void eliminar (ID id)throws Exception{
        getRepo().deleteById(id);
    }

}
