package com.techmind.enterprise.Services;

import com.techmind.enterprise.Model.Enterprise;
import com.techmind.enterprise.Repository.EnterpriseRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


import java.util.List;
import java.util.Optional;

@Service
public class EnterpriseService {

    @Autowired
    private EnterpriseRepository enterpriseRepository;

    public List<Enterprise> getEnterprise() {
        return enterpriseRepository.findAll();
    }

    public Enterprise getEnterprise(Long id) throws Exception {
        Optional<Enterprise> enterpriseOptional = enterpriseRepository.findById(id);
        if (enterpriseOptional.isPresent()) {
            return enterpriseOptional.get();
        }else {
            throw new Exception("Empresa no Existe");
        }
    }

    public Enterprise saveEnterprise(Enterprise enterprise_param) {
        return enterpriseRepository.save(enterprise_param);
    }

    public Enterprise putEnterprise(Enterprise enterprise_param) {
        return enterpriseRepository.save(enterprise_param);
    }

}
