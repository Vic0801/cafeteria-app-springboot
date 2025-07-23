package ec.sasf.Cafeteria.persistence.repository;

import ec.sasf.Cafeteria.persistence.entity.ProductoEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ProductoRepository extends JpaRepository<ProductoEntity , Long> {
List<ProductoEntity> findByDisponibleTrue();
}
