package com.prix.controller;

import com.prix.Service.ComercioService;
import com.prix.dto.ComercioDTO;
import com.prix.exception.ModelNotFoundException;
import com.prix.model.Comercio;
import org.modelmapper.ModelMapper;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/comercios")
public class ComercioController {

    private final ComercioService service;

    private final ModelMapper mapper;


    public ComercioController(ComercioService service, ModelMapper mapper) {
        this.service = service;
        this.mapper = mapper;
    }

    @GetMapping
    public ResponseEntity<List<ComercioDTO>> listar ()throws Exception{
        List<ComercioDTO> lista = service.listar().stream().map(d -> mapper.map(d, ComercioDTO.class)).collect(Collectors.toList());
        return new ResponseEntity<>(lista, HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<ComercioDTO> listarPorId (@PathVariable String id)throws Exception{
        Comercio comercio = service.listarPorId(id);

        if (comercio == null){
            throw new ModelNotFoundException("ID NO ENCONTRADO " + id);
        }

        ComercioDTO dto = mapper.map(comercio, ComercioDTO.class);
        return new ResponseEntity<>(dto, HttpStatus.OK);
    }

    @PostMapping()
    public ResponseEntity<ComercioDTO> registrar (@RequestBody ComercioDTO dto)throws Exception{
        dto.setMunicipio(dto.getMunicipio());
        Comercio comercio = mapper.map(dto, Comercio.class);
        Comercio com = service.registrarComercio(comercio);
        return new ResponseEntity<>(dto, HttpStatus.CREATED);
    }

    /*
    @PutMapping
    public ResponseEntity<ComercioDTO> modificar(@RequestBody ComercioDTO dto)throws Exception{
        Comercio com = service.listarPorId(dto.getIdComercio());

        if (com == null){
            throw new ModelNotFoundException("ID NO ENCONTRADO" + dto.getIdComercio());
        }

        Comercio comercio = mapper.map(dto, Comercio.class);
        Comercio come = service.modificar(comercio);
        return new ResponseEntity<>(dto, HttpStatus.OK);
    }*/

    @GetMapping("/totalComercios")
    public ResponseEntity<Long> totalComercios()throws Exception{
        long total = service.totalComercios();
        return new ResponseEntity<>(total, HttpStatus.OK);
    }

    @GetMapping("/totalComercios24")
    public ResponseEntity<Long> totalComercios24()throws Exception{
        long total = service.totalComercios24();
        return new ResponseEntity<>(total, HttpStatus.OK);
    }
}
