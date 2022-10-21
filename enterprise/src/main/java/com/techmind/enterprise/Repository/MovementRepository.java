package com.techmind.enterprise.Repository;

import com.techmind.enterprise.Model.MovementMoney;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface MovementRepository extends JpaRepository<MovementMoney, Long> {

    List<MovementMoney> findByEnterpriseId(Long id );


}
