package com.prix.Service;

import com.prix.model.Cliente;
import com.prix.model.Municipio;
import com.prix.model.Producto;
import com.prix.repo.IClienteRepo;
import com.prix.repo.IGenericRepo;
import com.prix.repo.IProductoRepo;
import jakarta.persistence.criteria.CriteriaBuilder;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

@Service
public class ProductoService extends CRUDImpl<Producto, String> {

    private final IProductoRepo repo;
    private final IClienteRepo clienteRepo;

    public ProductoService(IProductoRepo repo, IClienteRepo clienteRepo) {
        this.repo = repo;
        this.clienteRepo = clienteRepo;
    }

    @Override
    protected IGenericRepo<Producto, String> getRepo() {
        return repo;
    }

    public Producto registrarProducto(Producto producto) throws Exception {
        /*Optional<Producto> p = repo.findById(producto.getComercio().getIdComercio());
        producto.setMunicipio(p.get().getComercio().getMunicipio());*/

        producto.setFechaRegistro(LocalDateTime.now());

        return repo.save(producto);
    }

    public List<Producto> listarProductos(String producto)throws Exception{
        return repo.findAllByIdProducto(producto);
    }

    public List<Producto> listarPorMunicipio(Integer idMunicipio, String nombre)throws Exception{
        var test = repo.findAll();
        var test2 = test.stream()
                .filter(producto -> producto.getMunicipio() != null)
                .filter(producto -> producto.getMunicipio().getIdMunicipio().equals(idMunicipio)
                        && producto.getNombre().contains(nombre))
                .toList();
        return repo.findAllByMunicipioIdMunicipioAndNombreContainingIgnoreCase(idMunicipio, nombre);

    }

    /*public List<Producto> listarPorComercio(Integer id)throws Exception{
        return repo.findAllByComercioIdComercio(id);
    }*/







}