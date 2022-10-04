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

    public Enterprise patchEnterprise(Enterprise enterprise_param, Long id) throws Exception {
        try {
            Enterprise enterpriseBD = getEnterprise(id);

            if(enterprise_param.getName() != null) {
                enterpriseBD.setName(enterprise_param.getName());
            }

            if (enterprise_param.getAddress() != null){
                enterpriseBD.setAddress(enterprise_param.getAddress());
            }

            if (enterprise_param.getPhone() != 0) {
                enterpriseBD.setPhone(enterprise_param.getPhone());
            }

            if (enterprise_param.getNit() != null) {
                enterpriseBD.setNit(enterprise_param.getNit());
            }

            return saveEnterprise(enterpriseBD);

        } catch (Exception e) {
            throw new Exception("Empresa no se actualizo, porque no existe");
        }
    }

    public String deleteEnterprise(Long id) {
        enterpriseRepository.deleteById(id);
        return "Empresa Eliminada Exitosamente";
    }
}
