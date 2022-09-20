package com.techmind.project_enterprise.service;

import com.techmind.project_enterprise.model.Employee;

import java.util.List;

public interface IEmployeeService {
    List<Employee> getAllEmployees();
    Employee saveEmployee (Employee employee);
    Employee getEmployeeById(Integer id);
    Employee updateEmployee(Employee employee);
    void deleteEmployeeById(Integer id);

}
