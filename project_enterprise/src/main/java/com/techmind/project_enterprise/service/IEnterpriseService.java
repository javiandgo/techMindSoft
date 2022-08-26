package com.techmind.project_enterprise.service;

import com.techmind.project_enterprise.model.Enterprise;

import java.util.List;

public interface IEnterpriseService {
    Enterprise create(Enterprise enterprise) throws Exception;

    Enterprise update(Enterprise enterprise) throws Exception;

    List<Enterprise> readAll() throws Exception;

    Enterprise readById(Integer id) throws Exception;

    void delete(Integer id) throws Exception;
}
