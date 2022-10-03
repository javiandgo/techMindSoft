package com.techmind.enterprise.Services;

import com.techmind.enterprise.Model.Employee;
import com.techmind.enterprise.Repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class UserService {

    @Autowired
    private UserRepository userRepository;

    public List<Employee> getEmployee() {
        return userRepository.findAll();
    }

    public Employee getEmployee(Long id) throws Exception {
        Optional<Employee> employeeOptional = userRepository.findById(id);
        if(employeeOptional.isPresent()) {
            return employeeOptional.get();
        }else {
            throw new Exception("Empleado No Existe");
        }
    }

    public Employee saveEmployee(Employee employee_param) {

        return userRepository.save(employee_param);
    }

    public Employee putEmployee(Employee employee_param) {
        return userRepository.save(employee_param);
    }
}
