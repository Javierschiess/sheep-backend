package com.prix.controller;

import com.prix.Service.ProductoService;
import com.prix.dto.ProductoDTO;
import com.prix.exception.ModelNotFoundException;
import com.prix.model.Producto;
import org.modelmapper.ModelMapper;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

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
    public ResponseEntity<ProductoDTO> registrar(@RequestParam String nombre, @RequestParam String descripcion,
                                                        @RequestParam Float precio, @RequestParam MultipartFile multipartFile,
                                                        @RequestParam String categoria, @RequestParam String comercio,
                                                        @RequestParam String estado, @RequestParam int rating
                                                         )throws Exception{
        Producto product = service.registrarProducto(nombre, precio, multipartFile, descripcion,
                                                    categoria, comercio, estado, rating);

        ProductoDTO dto = mapper.map(product, ProductoDTO.class);

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
        //producto.setCategoria(dto.getCategoria());

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

   /* @GetMapping ("/buscarPorMunicipio")
    public ResponseEntity<List<Producto>> buscar (
            @RequestParam (value = "idMunicipio", required = true) String idMunicipio,
            @RequestParam(value = "nombre", required = true)String nombre)throws Exception{
        List<Producto> lista = service.listarPorMunicipio(idMunicipio, nombre);

        return new ResponseEntity<>(lista, HttpStatus.OK);
    }

    */

 @GetMapping("/buscarPorComercio")
    public ResponseEntity<List<Producto>> buscarPorComercio(
             @RequestParam (value = "idComercio", required = true) String idComercio) throws Exception{
        List<Producto> lista = service.listarPorComercio(idComercio);

        return new ResponseEntity<>(lista, HttpStatus.OK);
    }

    @GetMapping("/buscarPorMunicipio")
    public ResponseEntity<List<Producto>> buscarPorMunicipio(
            @RequestParam (value = "idCliente", required = true) String idCliente,
            @RequestParam (value = "idMunicipio", required = false) String idMunicipio) throws Exception{
     List<Producto> lista = service.listarPorMunicipio(idCliente, idMunicipio);
     return new ResponseEntity<>(lista, HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> eliminar( @PathVariable String id)throws Exception{
        service.eliminar(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }

    @GetMapping("/totalProductos")
    public ResponseEntity<Long> getTotalProduct()throws Exception{
    long  totalProductos = service.getTotalProduct();
    return new ResponseEntity<>(totalProductos, HttpStatus.OK);
    }

    @GetMapping("/totalProductos24")
    public ResponseEntity<Long> totalProductos24()throws Exception{
     long totalProductos24 = service.productos24();
     return new ResponseEntity<>(totalProductos24, HttpStatus.OK);
    }

}
