package com.techmind.enterprise.Controller;

import com.techmind.enterprise.Model.Employee;
import com.techmind.enterprise.Model.Enterprise;
import com.techmind.enterprise.Model.Response;
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
    public ResponseEntity<Object> getEnterprises(@RequestParam Long id) {
        try {
            Enterprise enterprise = enterpriseService.getEnterprise(id);
            return new ResponseEntity<>(enterprise, HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(e.getMessage(),
                    HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @PostMapping("/enterprise")
    public ResponseEntity<Response> postEnterprise(@RequestBody Enterprise enterprise) {
        return new ResponseEntity<>(
                new Response("Empresa creada exitosamente",
                enterpriseService.saveEnterprise(enterprise)),
                HttpStatus.OK);
    }

    @PutMapping("/enterprise")
    public ResponseEntity<Response> putEnterprise(@RequestBody Enterprise enterprise) {
        return new ResponseEntity<>(
                new Response("Empresa Actualizada Exitosamente",
                        enterpriseService.putEnterprise(enterprise))
                ,HttpStatus.OK);
    }

    @PatchMapping("/enterprise")
    public ResponseEntity<Response> patchEnterprise(@RequestBody Enterprise enterprise) {
        try {
            return new ResponseEntity<>(
                    new Response("Actualización Exitosa", enterpriseService.patchEnterprise(enterprise)),
                    HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(
                    new Response(e.getMessage(), null),
                    HttpStatus.OK);
        }
    }

    @DeleteMapping("enterprise/{id}")
    public ResponseEntity<Response> deleteEnterprise(@PathVariable Long id) {
        return new ResponseEntity<>(
                new Response(enterpriseService.deleteEnterprise(id), null),
                HttpStatus.OK
        );
    }
}
