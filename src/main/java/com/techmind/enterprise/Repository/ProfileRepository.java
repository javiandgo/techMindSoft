package com.techmind.enterprise.Repository;

import com.techmind.enterprise.Model.Profile;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ProfileRepository extends JpaRepository<Profile, Long> {

    Profile findByUsername(String username);

    Profile findByEmployee(Long id);
 }
