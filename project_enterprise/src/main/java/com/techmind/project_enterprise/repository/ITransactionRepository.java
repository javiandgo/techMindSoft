package com.techmind.project_enterprise.repository;

import com.techmind.project_enterprise.model.Transaction;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


public interface ITransactionRepository extends IGenericRepository<Transaction, Long> {
}
