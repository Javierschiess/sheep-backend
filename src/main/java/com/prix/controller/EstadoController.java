package com.prix.controller;

import com.prix.Service.EstadoService;
import com.prix.dto.EstadoDTO;
import com.prix.exception.ModelNotFoundException;
import com.prix.model.Estado;
import org.modelmapper.ModelMapper;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/estados")
public class EstadoController {

    private final EstadoService service;

    private final ModelMapper mapper;

    public EstadoController(EstadoService service, ModelMapper mapper) {
        this.service = service;
        this.mapper = mapper;
    }

    @GetMapping
    public ResponseEntity<List<EstadoDTO>> listar()throws Exception{
        List<EstadoDTO> lista = service.listar().stream().map(d -> mapper.map(d, EstadoDTO.class)).collect(Collectors.toList());
        return new ResponseEntity<>(lista, HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<EstadoDTO> registrar(@RequestBody EstadoDTO dto)throws Exception{
        Estado estado = mapper.map(dto, Estado.class);
        Estado estado1 = service.registrarEstado(estado);
        return new ResponseEntity<>(dto, HttpStatus.CREATED);
    }

    @GetMapping("/{id}")
    public ResponseEntity<EstadoDTO> listarPorId(@PathVariable("id") String id)throws Exception{
        Estado estado = service.listarPorId(id);

        if (estado == null){
            throw new ModelNotFoundException("ID NO ENCONTRADO" + id);
        }

        EstadoDTO dto = mapper.map(estado, EstadoDTO.class);

        return new ResponseEntity<>(dto, HttpStatus.OK);
    }




}
