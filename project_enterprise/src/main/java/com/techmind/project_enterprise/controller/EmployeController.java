package com.techmind.project_enterprise.controller;

import com.techmind.project_enterprise.model.Employe;
import com.techmind.project_enterprise.model.Enterprise;
import com.techmind.project_enterprise.service.IEmployeService;
import com.techmind.project_enterprise.service.IEnterpriseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/employes")
public class EmployeController {
    @Autowired
    private IEmployeService service;
    @GetMapping
    public List<Employe> readAll() throws Exception{
        return service.readAll();
    }

    @PostMapping
    public Employe create(@RequestBody Employe employe) throws Exception{
        return service.create(employe);
    }

    @GetMapping("/{id}")
    public Employe readById(@PathVariable("id")Integer id) throws Exception {
        return service.readById(id);
    }
    @PutMapping
    public Employe update(@RequestBody Employe employe) throws Exception{
        return service.update(employe);
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable("id") Integer id) throws Exception{
        service.delete(id);
    }
}
