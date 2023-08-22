package com.prix.controller;

import com.prix.Service.ProductoService;
import com.prix.dto.ClienteDTO;
import com.prix.dto.ProductoDTO;
import com.prix.exception.ModelNotFoundException;
import com.prix.model.Cliente;
import com.prix.model.Municipio;
import com.prix.model.Producto;
import jakarta.annotation.security.RolesAllowed;
import org.modelmapper.ModelMapper;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/productos")
public class ProductoController {

    private final ProductoService service;

    private final ModelMapper mapper;

    public ProductoController(ProductoService service, ModelMapper mapper) {
        this.service = service;
        this.mapper = mapper;
    }


    @GetMapping
    public ResponseEntity<List<ProductoDTO>> listar()throws Exception {
        List<ProductoDTO> lista = service.listar().stream().map(d -> mapper.map(d, ProductoDTO.class)).collect(Collectors.toList());
        return new ResponseEntity<>(lista, HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<ProductoDTO> listarPorId(@PathVariable String id)throws Exception{
        Producto producto = service.listarPorId(id);

        if (producto == null){
            throw new ModelNotFoundException("ID NO ENCONTRADO " + id);
        }

        ProductoDTO dto = mapper.map(producto, ProductoDTO.class);
        return new ResponseEntity<>(dto, HttpStatus.OK);
    }



    @PostMapping
    public ResponseEntity<ProductoDTO> registrar(@RequestBody ProductoDTO dto)throws Exception{
        Producto producto = mapper.map(dto, Producto.class);
        Producto product = service.registrarProducto(producto);
        return new ResponseEntity<>(dto, HttpStatus.CREATED);
    }

    @PutMapping
    public ResponseEntity<ProductoDTO> modificar(@RequestBody ProductoDTO dto)throws Exception{
        Producto producto = service.listarPorId(dto.getIdProducto());

        if (producto == null){
            throw new ModelNotFoundException("ID NO ENCONTRADO " + dto.getIdProducto());
        }

        producto.setNombre(dto.getNombre());
        producto.setDescripcion(dto.getDescripcion());
        producto.setFoto(dto.getFoto());
        producto.setPrecio(dto.getPrecio());

        Producto product = service.modificar(producto);
        return new ResponseEntity<>(dto, HttpStatus.OK);
    }

    @PostMapping("/buscarProducto")
    public ResponseEntity<List<Producto>> listar (@RequestBody Producto producto)throws Exception{
        List<Producto> lista = service.listarProductos(producto.getIdProducto());

        if (lista == null){
            throw new ModelNotFoundException("ID NO ENCONTRADO");
        }
        return new ResponseEntity<>(lista, HttpStatus.OK);
    }

    @GetMapping ("/buscarPorMunicipio")
    public ResponseEntity<List<Producto>> buscar (
            @RequestParam (value = "idMunicipio", required = true) String idMunicipio,
            @RequestParam(value = "nombre", required = true)String nombre)throws Exception{
        List<Producto> lista = service.listarPorMunicipio(idMunicipio, nombre);

        return new ResponseEntity<>(lista, HttpStatus.OK);
    }

   @GetMapping("/buscarPorComercio")
    public ResponseEntity<List<Producto>> buscarPorComercio(
             @RequestParam (value = "idComercio", required = true) String idComercio) throws Exception{
        List<Producto> lista = service.listarPorComercio(idComercio);

        return new ResponseEntity<>(lista, HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> eliminar( @PathVariable String id)throws Exception{
        service.eliminar(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }





}
