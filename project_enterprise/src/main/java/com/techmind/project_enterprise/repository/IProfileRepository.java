package com.techmind.project_enterprise.repository;

import com.techmind.project_enterprise.model.Profile;
import org.springframework.data.jpa.repository.JpaRepository;

public interface IProfileRepository extends JpaRepository<Profile,Integer> {
}
