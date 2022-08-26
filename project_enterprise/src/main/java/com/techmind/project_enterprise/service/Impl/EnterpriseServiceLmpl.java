package com.techmind.project_enterprise.service.Impl;

import com.techmind.project_enterprise.model.Enterprise;
import com.techmind.project_enterprise.repository.IenterpriseRepository;
import com.techmind.project_enterprise.service.IEnterpriseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EnterpriseServiceLmpl implements IEnterpriseService {
    @Autowired
    private IenterpriseRepository repo;

    public EnterpriseServiceLmpl(IenterpriseRepository repo){

        this.repo=repo;
    }

    @Override
    public Enterprise create(Enterprise enterprise) throws Exception {
        return repo.save(enterprise);
    }

    @Override
    public Enterprise update(Enterprise enterprise) throws Exception {
        return repo.save(enterprise);
    }

    @Override
    public List<Enterprise> readAll() throws Exception {
        return repo.findAll();
    }

    @Override
    public Enterprise readById(Integer id) throws Exception {
        return repo.findById(id).orElse(null);
    }

    @Override
    public void delete(Integer id) throws Exception {
        repo.deleteById(id);
    }
}
