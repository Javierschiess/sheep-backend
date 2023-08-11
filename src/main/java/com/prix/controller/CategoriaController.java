package com.prix.controller;

import com.prix.Service.CategoriaService;
import com.prix.dto.CategoriaDTO;
import com.prix.exception.ModelNotFoundException;
import com.prix.model.Categoria;
import org.modelmapper.ModelMapper;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/categorias")
public class CategoriaController {


    private  final CategoriaService service;


    private final ModelMapper mapper;

    public CategoriaController(CategoriaService service, ModelMapper mapper) {
        this.service = service;
        this.mapper = mapper;
    }

    @GetMapping
    public ResponseEntity<List<CategoriaDTO>> listar()throws Exception{
        List<CategoriaDTO> lista = service.listar().stream().map(d -> mapper.map(d, CategoriaDTO.class)).collect(Collectors.toList());
        return new ResponseEntity<>(lista, HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<CategoriaDTO> listarPorId(@PathVariable("id") Integer id)throws Exception{
        Categoria categoria = service.listarPorId(id);

        if (id == null){
            throw new ModelNotFoundException("ID NO ENCONTRADO" + id);
        }
        CategoriaDTO dto = mapper.map(categoria, CategoriaDTO.class);

        return new ResponseEntity<>(dto, HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<CategoriaDTO> registrar(@RequestBody CategoriaDTO dto)throws Exception{
        Categoria categoria = mapper.map(dto, Categoria.class);
        Categoria cat = service.registrarCategoria(categoria);

        return new ResponseEntity<>(dto, HttpStatus.CREATED);
    }

    @PutMapping
    public ResponseEntity<CategoriaDTO> modificar(@RequestBody CategoriaDTO dto) throws Exception{
        Categoria categoria = service.listarPorId(dto.getIdCategoria());

        if (categoria == null){
            throw new ModelNotFoundException("ID NO ENCONTRADO" + dto.getIdCategoria());
        }

        Categoria cat = mapper.map(dto, Categoria.class);
        Categoria cate = service.modificar(cat);

        return new ResponseEntity<>(dto, HttpStatus.OK);
    }


}
