package com.techmind.project_enterprise.service;

import com.techmind.project_enterprise.model.Employe;
import com.techmind.project_enterprise.model.Enterprise;

import java.util.List;

public interface IEmployeService {

    Employe create(Employe employe) throws Exception;

    Employe update(Employe employe) throws Exception;

    List<Employe> readAll() throws Exception;

    Employe readById(Integer id) throws Exception;

    void delete(Integer id) throws Exception;
}
