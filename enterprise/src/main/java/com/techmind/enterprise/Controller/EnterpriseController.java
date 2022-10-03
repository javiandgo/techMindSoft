package com.techmind.enterprise.Controller;

import com.techmind.enterprise.Model.Employee;
import com.techmind.enterprise.Model.Enterprise;
import com.techmind.enterprise.Model.UserResponse;
import com.techmind.enterprise.Services.EnterpriseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class EnterpriseController {

    @Autowired
    private EnterpriseService enterpriseService;
    @GetMapping("/enterprises")
    public ResponseEntity<List<Enterprise>> getEnterprises() {

        return new ResponseEntity<List<Enterprise>>(
                enterpriseService.getEnterprise(),
                HttpStatus.OK
        );
    }

    @GetMapping("/enterprise/{id}")
    public ResponseEntity<Object> getEnterprise(@PathVariable Long id) {

        try {
            Enterprise enterprise = enterpriseService.getEnterprise(id);
            return new ResponseEntity<>(enterprise, HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(e.getMessage(),
                    HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @GetMapping("/enterprise")
    public ResponseEntity<Enterprise> getEnterprises(@RequestParam Long id) {
        try {
            Enterprise enterprise = enterpriseService.getEnterprise(id);
            return new ResponseEntity<>(enterprise, HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(e.getMessage(),
                    HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @PostMapping("/enterprise")
    public ResponseEntity<Object> postEnterprise(@RequestBody Enterprise enterprise) {
        return new ResponseEntity<>(
                new UserResponse("Empleado creado exitosamente",
                        enterpriseService.saveEnterprise(enterprise)),
                HttpStatus.OK);
    }
}
