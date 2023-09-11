package com.prix.Service;

import com.prix.model.Cliente;
import com.prix.model.Comercio;
import com.prix.model.Municipio;
import com.prix.model.Producto;
import com.prix.repo.IClienteRepo;
import com.prix.repo.IComercioRepo;
import com.prix.repo.IGenericRepo;
import com.prix.repo.IProductoRepo;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

@Service
public class ProductoService extends CRUDImpl<Producto, String> {

    private final IProductoRepo repo;

    private final IComercioRepo comercioRepo;
    private final IClienteRepo clienteRepo;

    public ProductoService(IProductoRepo repo, IComercioRepo comercioRepo, IClienteRepo clienteRepo) {
        this.repo = repo;
        this.comercioRepo = comercioRepo;
        this.clienteRepo = clienteRepo;
    }

    @Override
    protected IGenericRepo<Producto, String> getRepo() {
        return repo;
    }

    public Producto registrarProducto(Producto producto) throws Exception {
        Optional<Comercio> comercio = comercioRepo.findById(producto.getComercio().getIdComercio());
        producto.setMunicipio(comercio.get().getMunicipio());

        producto.setFechaRegistro(LocalDateTime.now());
        return repo.save(producto);
    }

    public List<Producto> listarProductos(String producto)throws Exception{
        return repo.findAllByIdProducto(producto);
    }

  /*  public List<Producto> listarPorMunicipio(String idMunicipio, String nombre)throws Exception{
        var test = repo.findAll();
        var test2 = test.stream()
                .filter(producto -> producto.getMunicipio() != null)
                .filter(producto -> producto.getMunicipio().getIdMunicipio().equals(idMunicipio)
                        && producto.getNombre().contains(nombre))
                .toList();
        return repo.findAllByMunicipioIdMunicipioAndNombreContainingIgnoreCase(idMunicipio, nombre);

    }

   */

   public List<Producto> listarPorComercio(String idComercio)throws Exception{
        return repo.findAllByComercioIdComercio(idComercio);
    }

    public List<Producto> listarPorMunicipio(String idCliente, String idMunicipio)throws Exception{

        if (idMunicipio.isEmpty()) {

            Optional<Cliente> cliente = clienteRepo.findById(idCliente);
            String muni = cliente.get().getMunicipio().getIdMunicipio();

            return repo.findAllByMunicipio(muni);

        }else {
            return repo.findAllByMunicipio(idMunicipio);
        }
    }

    public long getTotalProduct()throws Exception{
       return repo.getAllProducto();
    }

    public long productos24()throws Exception{
       return repo.productos24();
    }



}