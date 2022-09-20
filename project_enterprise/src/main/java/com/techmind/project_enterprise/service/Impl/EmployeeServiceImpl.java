package com.techmind.project_enterprise.service.Impl;

import com.techmind.project_enterprise.model.Employee;
import com.techmind.project_enterprise.repository.IEmployeRepository;
import com.techmind.project_enterprise.service.IEmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EmployeeServiceImpl implements IEmployeeService {
    @Autowired
    private IEmployeRepository Employeerepo;


    @Override
    public List<Employee> getAllEmployees() {

        return Employeerepo.findAll();
    }

    @Override
    public Employee saveEmployee(Employee employee) {

        return Employeerepo.save(employee);
    }

    @Override
    public Employee getEmployeeById(Integer id) {

        return Employeerepo.findById(id).get();
    }

    @Override
    public Employee updateEmployee(Employee employee) {
        return Employeerepo.save(employee);
    }

    @Override
    public void deleteEmployeeById(Integer id) {
        Employeerepo.deleteById(id);
    }
}
