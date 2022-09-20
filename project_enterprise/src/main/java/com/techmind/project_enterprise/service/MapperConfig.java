package com.techmind.project_enterprise.service;

import com.techmind.project_enterprise.dto.TransactionDTO;
import com.techmind.project_enterprise.model.Transaction;
import org.modelmapper.ModelMapper;
import org.modelmapper.TypeMap;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class MapperConfig {
    @Bean("profileMapper")
    public ModelMapper profileMapper(){
    return new ModelMapper();
    }
    @Bean("enterpriseMapper")
    public ModelMapper enterpriseMapper(){
        return new ModelMapper();
    }
    @Bean("transactionMapper")
    public ModelMapper saleMapper(){
        ModelMapper mapper=new ModelMapper();
        TypeMap<TransactionDTO, Transaction> typeMap=mapper.createTypeMap(TransactionDTO.class, Transaction.class);
        typeMap.addMapping(TransactionDTO::getIdEnterprise,(dest, v)->dest.getEnterprise().setIdEnterprise((Long) v));
        return new ModelMapper();
    }

    @Bean("employeeMapper")
    public ModelMapper employeeMapper(){
        return new ModelMapper();
    }
}
