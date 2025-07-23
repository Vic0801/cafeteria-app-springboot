package ec.sasf.Cafeteria.persistence.repository;

import ec.sasf.Cafeteria.persistence.entity.ClienteEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ClienteRepository extends JpaRepository<ClienteEntity, Long> {

}
