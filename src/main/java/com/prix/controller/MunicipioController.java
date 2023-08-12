package com.prix.controller;

import com.prix.Service.MunicipioService;
import com.prix.dto.MunicipioDTO;
import com.prix.exception.ModelNotFoundException;
import com.prix.model.Municipio;
import org.modelmapper.ModelMapper;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/municipios")
public class MunicipioController {

    private final MunicipioService service;

    private final ModelMapper mapper;

    public MunicipioController(MunicipioService service, ModelMapper mapper) {
        this.service = service;
        this.mapper = mapper;
    }

    @GetMapping
    public ResponseEntity<List<MunicipioDTO>> listar()throws Exception{
        List<MunicipioDTO> lista = service.listar().stream().map(d -> mapper.map(d, MunicipioDTO.class)).collect(Collectors.toList());
        return new ResponseEntity<>(lista, HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<MunicipioDTO> listarPorId(@PathVariable String id)throws Exception{
        Municipio municipio = service.listarPorId(id);

        if (municipio == null){
            throw new ModelNotFoundException("ID NO ENCONTRADO " + id);
        }

        MunicipioDTO dto = mapper.map(municipio, MunicipioDTO.class);
        return new ResponseEntity<>(dto, HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<MunicipioDTO> registrar(@RequestBody MunicipioDTO dto)throws Exception{
        Municipio municipio = mapper.map(dto, Municipio.class);
        Municipio muni = service.registrar(municipio);
        return new ResponseEntity<>(dto, HttpStatus.CREATED);
    }
}
