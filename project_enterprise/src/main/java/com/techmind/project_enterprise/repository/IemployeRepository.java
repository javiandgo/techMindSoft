package com.techmind.project_enterprise.repository;

import com.techmind.project_enterprise.model.Employee;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


public interface IEmployeRepository extends IGenericRepository<Employee, Integer> {
}
