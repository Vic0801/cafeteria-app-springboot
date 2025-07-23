package ec.sasf.Cafeteria.service.mapper;

import ec.sasf.Cafeteria.persistence.entity.OrdenEntity;
import ec.sasf.Cafeteria.service.dto.OrdenDto;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring")
public interface OrdenMapper {

    // Convertir Entity → DTO (para GET)
    @Mapping(source = "cliente.idCliente", target = "clienteId")
    @Mapping(target = "productosIds",
            expression = "java(ordenEntity.getProductos().stream().map(p -> p.getIdProducto()).toList())")
//    @Mapping(target = "productos",
//            expression = "java(ordenEntity.getProductos().stream().map(p -> mapProductos(p)).toList())")
    OrdenDto ordenToDto (OrdenEntity ordenEntity);

    // Convertir DTO → Entity (para POST)
    @Mapping(target = "cliente", ignore = true)
    @Mapping(target = "productos", ignore = true)
    @Mapping(target = "total", ignore = true)
    OrdenEntity ordenToEntity ( OrdenDto ordenDto);


}
