package ec.sasf.Cafeteria.service;

import ec.sasf.Cafeteria.persistence.entity.ClienteEntity;
import ec.sasf.Cafeteria.persistence.entity.OrdenEntity;
import ec.sasf.Cafeteria.persistence.entity.ProductoEntity;
import ec.sasf.Cafeteria.persistence.repository.ClienteRepository;
import ec.sasf.Cafeteria.persistence.repository.OrdenRepository;
import ec.sasf.Cafeteria.persistence.repository.ProductoRepository;
import ec.sasf.Cafeteria.service.dto.OrdenDto;
import ec.sasf.Cafeteria.service.mapper.OrdenMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class OrdenService {
    @Autowired
    private OrdenRepository ordenRepository;
    @Autowired
    private ClienteRepository clienteRepository;
    @Autowired
    private ProductoRepository productoRepository;
    @Autowired
    private OrdenMapper ordenMapper;


   //Crear una orden para un cliente existente
   public OrdenEntity crearOrden (OrdenDto ordenDto){
       // Verificar que el cliente exista
       ClienteEntity cliente = clienteRepository.findById(ordenDto.getClienteId())
            .orElseThrow(()->new RuntimeException("Cliente no existe")) ;
       //Crear entidad vacía desde Dto
       OrdenEntity orden = ordenMapper.ordenToEntity(ordenDto);
       // Setear el cliente real en la orden
       orden.setCliente(cliente);

       // Cargar productos desde los IDs del DTO
       List<ProductoEntity> productos = productoRepository.findAllById(ordenDto.getProductosIds());

       if (productos.isEmpty()) {
           throw new RuntimeException("La orden no contiene productos válidos");
       }
       orden.setProductos(productos);

       // Calcular total si quieres (sumando precios)
       double total =  productos.stream()
               .mapToDouble(ProductoEntity::getPrecio)
               .sum();
       orden.setTotal(total);

       return ordenRepository.save(orden);
   }

    // Obtener todas las órdenes de un cliente específico
    public List<OrdenEntity> listarPorId(Long clienteId) {
        Optional<ClienteEntity> op = clienteRepository.findById(clienteId);
        if(op.isEmpty()){
            throw new RuntimeException("Cliente no existe");
        }
        return ordenRepository.findByCliente_IdCliente(clienteId);
    }
}

