package com.prix.Service;

import com.prix.model.*;
import com.prix.repo.*;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;
import java.util.Map;
import java.util.Optional;

@Service
public class ProductoService extends CRUDImpl<Producto, String> {

    private final IProductoRepo repo;

    private final ICategoriaRepo categoriaRepo;

    private final IComercioRepo comercioRepo;

    private final IEstadoRepo estadoRepo;
    private final IClienteRepo clienteRepo;

    private final CloudinaryService cloudinaryService;

    public ProductoService(IProductoRepo repo, ICategoriaRepo categoriaRepo, IComercioRepo comercioRepo, IEstadoRepo estadoRepo, IClienteRepo clienteRepo, CloudinaryService cloudinaryService) {
        this.repo = repo;
        this.categoriaRepo = categoriaRepo;
        this.comercioRepo = comercioRepo;
        this.estadoRepo = estadoRepo;
        this.clienteRepo = clienteRepo;
        this.cloudinaryService = cloudinaryService;
    }

    @Override
    protected IGenericRepo<Producto, String> getRepo() {
        return repo;
    }

    public Producto registrarProducto(String nombre, Float precio, MultipartFile multipartFile,
                                      String descripcion, String idCategoria, String idComercio,
                                      String idEstado, int rating) throws Exception {
        Optional<Comercio> comercio = comercioRepo.findById(idComercio);
        Optional<Estado> estado  = estadoRepo.findById(idEstado);
        Optional<Categoria> categoria = categoriaRepo.findById(idCategoria);
        Producto producto = new Producto();
        producto.setNombre(nombre);
        producto.setPrecio(precio);
        producto.setDescripcion(descripcion);
        producto.setCategoria(categoria.get());
        producto.setRating(rating);
        producto.setEstado(estado.get());
        producto.setComercio(comercio.get());
        producto.setMunicipio(comercio.get().getMunicipio());

        Map result = cloudinaryService.upload(multipartFile);
        String urlImage = (String) result.get("url");

        producto.setFoto(urlImage);
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

    public List<Producto>listarPorMunicipio(String idCliente, String idMunicipio)throws Exception{

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