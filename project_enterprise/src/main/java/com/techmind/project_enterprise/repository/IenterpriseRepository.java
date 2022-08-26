package com.techmind.project_enterprise.repository;

import com.techmind.project_enterprise.model.Enterprise;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IenterpriseRepository extends JpaRepository<Enterprise, Integer> {

}
