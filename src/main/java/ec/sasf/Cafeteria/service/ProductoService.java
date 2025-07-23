package ec.sasf.Cafeteria.service;

import ec.sasf.Cafeteria.persistence.entity.ProductoEntity;
import ec.sasf.Cafeteria.persistence.repository.ProductoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ProductoService  {
    @Autowired
    private ProductoRepository productoRepository;

    public List<ProductoEntity> listarTodos() {
        return productoRepository.findByDisponibleTrue();
    }


    public ProductoEntity crearProducto(ProductoEntity producto){
        ProductoEntity nuevoProducto = new ProductoEntity();
        nuevoProducto.setDisponible(true);
        nuevoProducto.setNombre(producto.getNombre());
        nuevoProducto.setPrecio(producto.getPrecio());
        return productoRepository.save(nuevoProducto);
    }

    public ProductoEntity actualizarProducto(Long idProducto, boolean disponible){
        Optional<ProductoEntity> producto = productoRepository.findById(idProducto);
        if(producto.isEmpty()){
            throw new RuntimeException("Producto no existe");
        }
        ProductoEntity productoActualizado = producto.get();
        productoActualizado.setDisponible(disponible);

        return productoRepository.save(productoActualizado);
    }

}
