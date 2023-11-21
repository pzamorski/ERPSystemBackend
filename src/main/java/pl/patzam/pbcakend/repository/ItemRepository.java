package pl.patzam.pbcakend.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import pl.patzam.pbcakend.entity.Item;

public interface ItemRepository extends JpaRepository<Item, Long> {
}
