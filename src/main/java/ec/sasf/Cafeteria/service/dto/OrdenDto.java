package ec.sasf.Cafeteria.service.dto;


import lombok.Data;

import java.time.LocalDate;

import java.util.List;
@Data
public class OrdenDto {

    private Long idOrden;
    private Double total;
    private Long clienteId;
    private List<Long> productosIds; //para usarlo en el POST
    private List<ProductoDto> productos; //para usarlo en el GET o POST de regreso
    private LocalDate fecha;
    }

