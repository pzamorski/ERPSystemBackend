package pl.patzam.pbcakend.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import pl.patzam.pbcakend.entity.Operator;

import java.util.Optional;

public interface OperatorRepository extends JpaRepository<Operator, Long> {

    public Optional<Operator> findByLogin(String login);
}
