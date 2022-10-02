package com.techmind.enterprise.Services;

import com.techmind.enterprise.Model.Employee;
import com.techmind.enterprise.Repository.EmployeeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class EmployeeService {

    @Autowired
    private EmployeeRepository employeeRepository;

    public List<Employee> getEmployee() {
        return employeeRepository.findAll();
    }

    public Employee getEmployee(Long id) throws Exception {
        Optional<Employee> employeeOptional = employeeRepository.findById(id);
        if(employeeOptional.isPresent()) {
            return employeeOptional.get();
        }else {
            throw new Exception("Empleado No Existe");
        }
    }

    public Employee saveEmployee(Employee employee_param) {
        return employeeRepository.save(employee_param);
    }
}
