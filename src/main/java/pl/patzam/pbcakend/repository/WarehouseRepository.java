package pl.patzam.pbcakend.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import pl.patzam.pbcakend.entity.Warehouse;

public interface WarehouseRepository extends JpaRepository<Warehouse, Long> {
}
