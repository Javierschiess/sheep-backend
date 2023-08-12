package com.prix.controller;

import com.prix.Service.DepartamentoService;
import com.prix.dto.DepartamentoDTO;
import com.prix.exception.ModelNotFoundException;
import com.prix.model.Departamento;
import org.modelmapper.ModelMapper;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/departamentos")
public class DepartamentoController {

    private final DepartamentoService service;
    private final ModelMapper mapper;

    public DepartamentoController(DepartamentoService service, ModelMapper mapper) {
        this.service = service;
        this.mapper = mapper;
    }

    @GetMapping
    public ResponseEntity<List<DepartamentoDTO>> listar ()throws Exception{
        List<DepartamentoDTO> lista = service.listar().stream().map(d -> mapper.map(d, DepartamentoDTO.class)).collect(Collectors.toList());
        return new ResponseEntity<>(lista, HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<DepartamentoDTO> listarPorId(@PathVariable String id)throws Exception{
        Departamento departamento = service.listarPorId(id);

        if (departamento == null){
            throw new ModelNotFoundException("ID NO ENCONTRADO " + id);
        }

        DepartamentoDTO dto = mapper.map(departamento, DepartamentoDTO.class);
        return new ResponseEntity<>(dto, HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<DepartamentoDTO> registrar(@RequestBody DepartamentoDTO dto)throws Exception{
        Departamento departamento = mapper.map(dto, Departamento.class);
        Departamento depa = service.registrar(departamento);
        return new ResponseEntity<>(dto, HttpStatus.CREATED);
    }
}
