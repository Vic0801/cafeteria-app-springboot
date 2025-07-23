package ec.sasf.Cafeteria.web.controller;

import ec.sasf.Cafeteria.persistence.entity.ProductoEntity;
import ec.sasf.Cafeteria.service.ProductoService;
import ec.sasf.Cafeteria.service.dto.ProductoDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("api/productos")
public class ProductoController {

    @Autowired
    private ProductoService productoService;


    @PostMapping
    public ResponseEntity<ProductoEntity> crearProducto(@RequestBody ProductoEntity producto) {
        ProductoEntity productoNuevo = productoService.crearProducto(producto);
        return ResponseEntity.ok(productoNuevo);
    }

    @GetMapping("/disponibles")
    public ResponseEntity<List<ProductoEntity>> listarProductos() {
        List<ProductoEntity> productos = this.productoService.listarTodos();
        return ResponseEntity.ok(productos);
    }


    @PutMapping("/{id}/disponibilidad")
    public ResponseEntity<ProductoEntity> actualizarDisponibilidad(
            @PathVariable Long id,
            @RequestBody Map<String, Boolean> disponibleMap) {

        Boolean disponible = disponibleMap.get("disponible");
        ProductoEntity actualizado = productoService.actualizarProducto(id, disponible);

        return ResponseEntity.ok(actualizado);

    }
}