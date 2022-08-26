package com.techmind.project_enterprise.repository;

import com.techmind.project_enterprise.model.MoneyMovement;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ImoneyMovementRepository extends JpaRepository<MoneyMovement, Integer> {
}
