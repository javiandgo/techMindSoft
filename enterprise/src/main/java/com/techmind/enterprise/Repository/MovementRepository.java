package com.techmind.enterprise.Repository;

import com.techmind.enterprise.Model.MovementMoney;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface MovementRepository extends JpaRepository<MovementMoney, Long> {

    public MovementMoney findByEnterpriseId(Long id );
}
