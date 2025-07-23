package ec.sasf.Cafeteria.web.controller;

import ec.sasf.Cafeteria.persistence.entity.ClienteEntity;
import ec.sasf.Cafeteria.persistence.entity.ProductoEntity;
import ec.sasf.Cafeteria.service.ClienteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("api/clientes")
public class ClienteController {
    @Autowired
    private ClienteService clienteService;

    @PostMapping
    public ResponseEntity<ClienteEntity> crearCliente(@RequestBody ClienteEntity cliente){
        ClienteEntity clienteNuevo = clienteService.crearCliente(cliente);
        return ResponseEntity.ok( clienteNuevo);
    }
}
