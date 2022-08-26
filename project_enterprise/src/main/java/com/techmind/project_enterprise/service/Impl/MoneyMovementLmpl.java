package com.techmind.project_enterprise.service.Impl;

import com.techmind.project_enterprise.model.MoneyMovement;
import com.techmind.project_enterprise.repository.ImoneyMovementRepository;
import com.techmind.project_enterprise.service.IMoneyMovementService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class MoneyMovementLmpl implements IMoneyMovementService {
    @Autowired
    private ImoneyMovementRepository repo;

    public MoneyMovementLmpl(ImoneyMovementRepository repo){
        this.repo=repo;
    }
    @Override
    public MoneyMovement create(MoneyMovement moneymovement) throws Exception {
        return repo.save(moneymovement);
    }

    @Override
    public MoneyMovement update(MoneyMovement moneymovement) throws Exception {
        return repo.save(moneymovement);
    }

    @Override
    public List<MoneyMovement> readAll() throws Exception {
        return repo.findAll();
    }

    @Override
    public MoneyMovement readById(Integer id) throws Exception {
        return repo.findById(id).orElse(null);
    }


    @Override
    public void delete(Integer id) throws Exception {
        repo.deleteById(id);
    }
}
