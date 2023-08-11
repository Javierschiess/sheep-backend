package com.prix.controller;

import com.prix.Service.ClienteService;
import com.prix.dto.ClienteDTO;
import com.prix.exception.ModelNotFoundException;
import com.prix.model.Cliente;
import org.modelmapper.ModelMapper;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/clientes")
public class ClienteController {

    private final ClienteService service;

    private final ModelMapper mapper;

    public ClienteController(ClienteService service, ModelMapper mapper) {
        this.service = service;
        this.mapper = mapper;
    }

    @GetMapping
    public ResponseEntity<List<ClienteDTO>> listar()throws Exception{
        List<ClienteDTO> lista = service.listar().stream().map(d -> mapper.map(d,ClienteDTO.class)).collect(Collectors.toList());
        return new ResponseEntity<>(lista, HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<ClienteDTO> listarPorId(@PathVariable("id") Integer id)throws Exception{
        Cliente cliente = service.listarPorId(id);

        if (id == null){
            throw new ModelNotFoundException("ID NO ENCONTRADO" + id);
        }

        ClienteDTO dto = mapper.map(cliente, ClienteDTO.class);
        return new ResponseEntity<>(dto, HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<ClienteDTO> registrar(@RequestBody ClienteDTO dto)throws Exception{
        Cliente cliente = mapper.map(dto, Cliente.class);
        Cliente client = service.registrarCliente(cliente);
        return new ResponseEntity<>(dto, HttpStatus.CREATED);
    }

    @PutMapping
    public ResponseEntity<ClienteDTO> modificar(@RequestBody ClienteDTO dto)throws Exception{
        Cliente c = service.listarPorId(dto.getIdCliente());

        if (c == null){
            throw new ModelNotFoundException("ID NO ENCONTRADO" + dto.getIdCliente());
        }

        Cliente client = mapper.map(dto, Cliente.class);
        Cliente cliente = service.modificar(client);
        return new ResponseEntity<>(dto, HttpStatus.OK);
    }

}
