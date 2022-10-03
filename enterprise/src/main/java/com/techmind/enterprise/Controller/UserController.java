package com.techmind.enterprise.Controller;

import com.techmind.enterprise.Model.Employee;
import com.techmind.enterprise.Model.UserResponse;
import com.techmind.enterprise.Services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class UserController {

    @Autowired
    private UserService userService;

    @GetMapping("/users")
    public ResponseEntity<List<Employee>> getEmployees(){

        return new ResponseEntity<List<Employee>>(
                userService.getEmployee(),
                HttpStatus.OK
                );
    }

    @GetMapping("/user/{id}")
    public ResponseEntity<Object> getEmployee(@PathVariable Long id) {

        try {
            Employee employee = userService.getEmployee(id);
            return new ResponseEntity<>(employee, HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(e.getMessage(),
                    HttpStatus.INTERNAL_SERVER_ERROR);
        }

    }

    @GetMapping("/user")
    public ResponseEntity<Object> getEmployees(@RequestParam Long id) {
        try {
            Employee employee = userService.getEmployee(id);
            return new ResponseEntity<>(employee, HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(e.getMessage(),
                    HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @PostMapping("/user")
    public ResponseEntity<UserResponse> postEmployee(@RequestBody Employee employee) {
        return new ResponseEntity<>(
                new UserResponse("Empleado creado exitosamente",
                userService.saveEmployee(employee)),
                HttpStatus.OK);
    }

    @PutMapping("/usuario")
    public ResponseEntity<UserResponse> putEmployee(@RequestBody Employee employee) {
        return new ResponseEntity<>(
                new UserResponse("Usuario Actualizado Exitosamente", userService.putEmployee(employee))
                ,HttpStatus.OK);
    }

}
