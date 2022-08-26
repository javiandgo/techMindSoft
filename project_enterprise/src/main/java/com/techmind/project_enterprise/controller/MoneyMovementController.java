package com.techmind.project_enterprise.controller;

import com.techmind.project_enterprise.model.MoneyMovement;
import com.techmind.project_enterprise.service.IMoneyMovementService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/movements")
public class MoneyMovementController {
    @Autowired
    private IMoneyMovementService service;
    @GetMapping
    public List<MoneyMovement> readAll() throws Exception{
        return service.readAll();
    }

    @PostMapping
    public MoneyMovement create(@RequestBody MoneyMovement moneyMovement) throws Exception{
        return service.create(moneyMovement);
    }

    @GetMapping("/{id}")
    public MoneyMovement readById(@PathVariable("id")Integer id) throws Exception {
        return service.readById(id);
    }
    @PutMapping
    public MoneyMovement update(@RequestBody MoneyMovement moneyMovement) throws Exception{
        return service.update(moneyMovement);
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable("id") Integer id) throws Exception{
        service.delete(id);
    }
}
