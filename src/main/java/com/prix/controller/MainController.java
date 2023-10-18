package com.prix.controller;

import com.prix.Service.CloudinaryService;
import com.prix.Service.ImagenService;
import com.prix.dto.Mensaje;
import com.prix.model.Imagen;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/cloudinary")
@CrossOrigin
public class MainController {

    @Autowired
    CloudinaryService cloudinaryService;

    @Autowired
    ImagenService service;

    @GetMapping("/list")
    public ResponseEntity<List<Imagen>> list(){
        List<Imagen> list = service.list();
        return new ResponseEntity<>(list, HttpStatus.OK);
    }

    @PostMapping("/upload")
    public ResponseEntity<?> upload(@RequestParam MultipartFile multipartFile)throws IOException {
        BufferedImage bi = ImageIO.read(multipartFile.getInputStream());
        if (bi == null){
            return new ResponseEntity(new Mensaje("Imagen no valida"), HttpStatus.BAD_REQUEST);
        }
        Map result = cloudinaryService.upload(multipartFile);
        Imagen imagen = new Imagen((String) result.get("original_filename"),
                                    (String) result.get("url"),
                                    (String) result.get("public_id"));
        service.save(imagen);
        return new ResponseEntity<>(new Mensaje("Imagen Subida"), HttpStatus.OK);
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<?> delete(@PathVariable("id") String id)throws IOException{
        Map result = cloudinaryService.delete(id);
        return new ResponseEntity<>(result, HttpStatus.NO_CONTENT);
    }

}
