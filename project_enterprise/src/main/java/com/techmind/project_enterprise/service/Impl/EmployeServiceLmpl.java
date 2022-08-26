package com.techmind.project_enterprise.service.Impl;

import com.techmind.project_enterprise.model.Employe;
import com.techmind.project_enterprise.repository.IemployeRepository;
import com.techmind.project_enterprise.repository.IenterpriseRepository;
import com.techmind.project_enterprise.service.IEmployeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EmployeServiceLmpl implements IEmployeService {
    @Autowired
    private IemployeRepository repo;

    public EmployeServiceLmpl(IemployeRepository repo){

        this.repo=repo;
    }
    @Override
    public Employe create(Employe employe) throws Exception {
        return repo.save(employe);
    }

    @Override
    public Employe update(Employe employe) throws Exception {
        return repo.save(employe);
    }

    @Override
    public List<Employe> readAll() throws Exception {
        return repo.findAll();
    }

    @Override
    public Employe readById(Integer id) throws Exception {
        return repo.findById(id).orElse(null);
    }

    @Override
    public void delete(Integer id) throws Exception {
        repo.deleteById(id);
    }
}
