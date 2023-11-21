package pl.patzam.pbcakend.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import pl.patzam.pbcakend.entity.QuantityType;

public interface QuantityTypeRepository extends JpaRepository<QuantityType, Long> {
}
