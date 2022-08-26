package com.techmind.project_enterprise.service;

import com.techmind.project_enterprise.model.MoneyMovement;

import java.util.List;

public interface IMoneyMovementService {

    MoneyMovement create(MoneyMovement moneymovement) throws Exception;

    MoneyMovement update(MoneyMovement moneymovement) throws Exception;

    List<MoneyMovement> readAll() throws Exception;

    MoneyMovement readById(Integer id) throws Exception;


    void delete(Integer id) throws Exception;
}
