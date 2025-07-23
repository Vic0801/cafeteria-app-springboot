package ec.sasf.Cafeteria.service.dto;

import lombok.Data;

@Data
public class ProductoDto {
    private Long idProducto;
    private String nombre;
    private Double precio;
    private Boolean disponible;
}