package com.techmind.project_enterprise.service.Impl;

import com.techmind.project_enterprise.model.Enterprise;
import com.techmind.project_enterprise.repository.IEnterpriseRepository;
import com.techmind.project_enterprise.repository.IGenericRepository;
import com.techmind.project_enterprise.service.IEnterpriseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EnterpriseServiceImpl extends CRUDImpl<Enterprise,Long> implements IEnterpriseService {
@Autowired
private  IEnterpriseRepository repo;
    @Override
    protected IGenericRepository<Enterprise, Long> getRepo() {
        return repo;
    }
}
