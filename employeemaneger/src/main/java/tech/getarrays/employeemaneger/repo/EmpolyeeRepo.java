package tech.getarrays.employeemaneger.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import tech.getarrays.employeemaneger.model.Employee;

import java.util.Optional;


public interface EmpolyeeRepo extends JpaRepository<Employee,Long> {

    void deleteEmployeeById(Long id);

    Optional<Employee> findEmployeeById(Long id);
}
