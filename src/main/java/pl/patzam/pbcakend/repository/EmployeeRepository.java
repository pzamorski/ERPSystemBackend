package pl.patzam.pbcakend.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import pl.patzam.pbcakend.entity.Employee;

public interface EmployeeRepository extends JpaRepository<Employee, Long> {
}
