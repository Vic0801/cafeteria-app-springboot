package ec.sasf.Cafeteria.web.controller;

import ec.sasf.Cafeteria.persistence.entity.OrdenEntity;
import ec.sasf.Cafeteria.service.OrdenService;
import ec.sasf.Cafeteria.service.dto.OrdenDto;
import ec.sasf.Cafeteria.service.mapper.OrdenMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/ordenes")
public class OrdenController {
    @Autowired
    private OrdenService ordenService;
    @Autowired
    private OrdenMapper ordenMapper;

    @PostMapping
    public ResponseEntity<OrdenDto> crearOrden(@RequestBody OrdenDto orden) {
        OrdenEntity ordenNueva = ordenService.crearOrden(orden);
        OrdenDto dto = ordenMapper.ordenToDto(ordenNueva);
        return ResponseEntity.status(HttpStatus.CREATED).body(dto);
    }

    @GetMapping("/cliente/{idCliente}")
    public ResponseEntity<List<OrdenEntity>> verOrdenesPorID(@PathVariable Long idCliente) {
        List<OrdenEntity> ordenes = ordenService.listarPorId(idCliente);
        return ResponseEntity.ok(ordenes);
    }
}

