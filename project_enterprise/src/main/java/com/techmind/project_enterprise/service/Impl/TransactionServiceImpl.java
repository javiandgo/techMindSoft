package com.techmind.project_enterprise.service.Impl;

import com.techmind.project_enterprise.model.Transaction;
import com.techmind.project_enterprise.repository.IGenericRepository;
import com.techmind.project_enterprise.repository.ITransactionRepository;
import com.techmind.project_enterprise.service.ITransactionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class TransactionServiceImpl extends CRUDImpl<Transaction, Long> implements ITransactionService {
    @Autowired
    private ITransactionRepository repo;
    @Override
    protected IGenericRepository<Transaction, Long> getRepo() {
        return repo;
    }
}
