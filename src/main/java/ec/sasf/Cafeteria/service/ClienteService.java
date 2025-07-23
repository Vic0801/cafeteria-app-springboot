package ec.sasf.Cafeteria.service;


import ec.sasf.Cafeteria.persistence.entity.ClienteEntity;
import ec.sasf.Cafeteria.persistence.repository.ClienteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ClienteService {
    @Autowired
    private ClienteRepository clienteRepository;

    public ClienteEntity crearCliente(ClienteEntity cliente){
        return clienteRepository.save(cliente);
    }
}
