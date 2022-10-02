package com.techmind.enterprise.Controller;

import com.techmind.enterprise.Model.Employee;
import com.techmind.enterprise.Model.EmployeeResponse;
import com.techmind.enterprise.Services.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
public class EmployeeController {

    @Autowired
    private EmployeeService employeeService;

    @GetMapping("/users")
    public ResponseEntity<List<Employee>> getEmployees(){

        return new ResponseEntity<List<Employee>>(
                employeeService.getEmployee(),
                HttpStatus.OK
                );
    }

    @GetMapping("/user/{id}")
    public ResponseEntity<Object> getEmployee(@PathVariable Long id) {

        try {
            Employee employee = employeeService.getEmployee(id);
            return new ResponseEntity<>(employee, HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(e.getMessage(),
                    HttpStatus.INTERNAL_SERVER_ERROR);
        }

    }

    @GetMapping("/user")
    public ResponseEntity<Object> getEmployees(@RequestParam Long id) {
        try {
            Employee employee = employeeService.getEmployee(id);
            return new ResponseEntity<>(employee, HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(e.getMessage(),
                    HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @PostMapping("/user")
    public ResponseEntity<EmployeeResponse> postEmployee(@RequestBody Employee employee) {
        return new ResponseEntity<>(
                new EmployeeResponse("Empleado creado exitosamente",
                employeeService.saveEmployee(employee)),
                HttpStatus.OK);
    }

}
