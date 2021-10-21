package tech.getarrays.employeemaneger.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import tech.getarrays.employeemaneger.exception.UserNoFoundException;
import tech.getarrays.employeemaneger.model.Employee;
import tech.getarrays.employeemaneger.repo.EmpolyeeRepo;

import java.util.List;
import java.util.UUID;

@Service
public class EmployeeService {
    private final EmpolyeeRepo empolyeeRepo;

    @Autowired
    public EmployeeService(EmpolyeeRepo empolyeeRepo) {
        this.empolyeeRepo = empolyeeRepo;
    }

    public Employee addEmployee(Employee employee){
        employee.setEmployeeCode(UUID.randomUUID().toString());
        return empolyeeRepo.save(employee);
    }

    public List<Employee> findAllEmployees(){
        return empolyeeRepo.findAll();
    }

    public Employee updateEmployee(Employee employee){
        return empolyeeRepo.save(employee);
    }

    public Employee findEmployeeById (Long id){
        return empolyeeRepo.findEmployeeById(id)
                .orElseThrow(() -> new UserNoFoundException("user by id" + id +" was not found"));
    }

    public void deleteEmployee(Long id){
        empolyeeRepo.deleteEmployeeById(id);
    }
}
