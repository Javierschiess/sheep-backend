package com.prix.Service;

import com.prix.model.Menu;
import com.prix.repo.IGenericRepo;
import com.prix.repo.IMenuRepo;
import org.springframework.stereotype.Service;

@Service
public class MenuService extends CRUDImpl<Menu, Integer> {

    private final IMenuRepo repo;

    public MenuService(IMenuRepo repo) {
        this.repo = repo;
    }

    @Override
    protected IGenericRepo<Menu, Integer> getRepo() {
        return repo;
    }
}
