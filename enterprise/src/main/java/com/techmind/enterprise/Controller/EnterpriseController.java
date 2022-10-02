package com.techmind.enterprise.Controller;

import com.techmind.enterprise.Model.Enterprise;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class EnterpriseController {
    @GetMapping("/enterprises")
    public ResponseEntity<List<Enterprise>> getEnterprises() {
        return null;
    }

    @GetMapping("/enterprise/{id}")
    public ResponseEntity<Enterprise> getEnterprise(@PathVariable Long id) {
        return null;
    }

    @GetMapping("/enterprise")
    public ResponseEntity<Enterprise> getEnterprises(@RequestParam Long id) {
        return null;
    }
}
