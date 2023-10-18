package com.prix.Service;

import com.prix.model.Imagen;
import com.prix.repo.ImagenRepo;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@Transactional
public class ImagenService {

    @Autowired
    ImagenRepo repo;

    public List<Imagen> list(){
        return repo.findByOrderById();
    }

    public void save (Imagen imagen){
        repo.save(imagen);
    }

    public void delete(String id){
        repo.deleteById(id);
    }

}
