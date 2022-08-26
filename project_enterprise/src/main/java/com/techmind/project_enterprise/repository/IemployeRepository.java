package com.techmind.project_enterprise.repository;

import com.techmind.project_enterprise.model.Employe;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IemployeRepository extends JpaRepository<Employe, Integer> {
}
