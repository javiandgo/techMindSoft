package com.techmind.enterprise.Repository;

import com.techmind.enterprise.Model.Employee;
import com.techmind.enterprise.Model.Profile;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends JpaRepository<Employee, Long> {

    Employee findByEmail(String email);
}
