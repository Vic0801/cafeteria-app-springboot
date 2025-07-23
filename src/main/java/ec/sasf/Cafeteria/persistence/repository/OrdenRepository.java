package ec.sasf.Cafeteria.persistence.repository;

import ec.sasf.Cafeteria.persistence.entity.OrdenEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;


public interface OrdenRepository extends JpaRepository<OrdenEntity, Long> {
    List<OrdenEntity> findByCliente_IdCliente(Long clienteId);
}
