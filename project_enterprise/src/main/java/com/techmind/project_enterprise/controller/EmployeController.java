package com.techmind.project_enterprise.controller;

import com.techmind.project_enterprise.model.Employee;
import com.techmind.project_enterprise.model.Profile;
import com.techmind.project_enterprise.service.IEmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

/*@RestController
@RequestMapping("/employees")*/
@Controller
public class EmployeController {
    @Autowired
    private IEmployeeService service;
    /*@Autowired
    @Qualifier("employeeMapper")
    private ModelMapper mapper;*/
    @GetMapping("/employees")
    public String viewHomePage(Model model){
        model.addAttribute("employees",service.getAllEmployees());
        return "employee/employees";
    }
    @GetMapping("/employees/nuevo")
    public String formularioRegistro(Model model){
        Employee employee = new Employee();
        model.addAttribute("employee",employee);
        return "employee/create_employee";
    }
    @PostMapping("/employees")
    public String saveEmployee(@ModelAttribute("employee")Employee employee){
        service.saveEmployee(employee);
        return "redirect:/employees";

    }
    @GetMapping("/employees/editar/{id}")
    public  String formularioEditar(@PathVariable Integer id,Model model){
        model.addAttribute("profile",service.getEmployeeById(id));
        return "profile/edit_employee";
    }
    @PostMapping("employees/{id}")
    public String updateProfiles(@PathVariable Integer id, @ModelAttribute("employee") Employee employee, Model model){
        Employee employeeExistent = service.getEmployeeById(id);
        employeeExistent.setIdEmploye(id);
        employeeExistent.setName_employee(employee.getName_employee());
        employeeExistent.setEmail_employee(employee.getEmail_employee());
        employeeExistent.setProfile(employee.getProfile());
        employeeExistent.setRoleName(employee.getRoleName());
        employeeExistent.setEnterprise(employee.getEnterprise());
        employeeExistent.setTransaction(employee.getTransaction());
        employeeExistent.setCreatedAt(employee.getCreatedAt());

        service.updateEmployee(employeeExistent);
        return "redirect:/employees";
    }
    @GetMapping("/employees/{id}")
    public String deleteEmployee(@PathVariable Integer id){
        service.deleteEmployeeById(id);
        return "redirect:/employees";
    }

}
