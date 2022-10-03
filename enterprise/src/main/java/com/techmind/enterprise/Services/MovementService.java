package com.techmind.enterprise.Services;

import com.techmind.enterprise.Model.MovementMoney;
import com.techmind.enterprise.Repository.MovementRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


import java.util.List;
import java.util.Optional;

@Service
public class MovementService {

    @Autowired
    private MovementRepository movementRepository;

    public List<MovementMoney> getMovement() {
        return movementRepository.findAll();
    }

    public MovementMoney getMovement(Long id) throws Exception {
        Optional<MovementMoney> movementOptional = movementRepository.findById(id);
        if (movementOptional.isPresent()) {
            return movementOptional.get();
        }else {
            throw new Exception("Empresa no Existe");
        }
    }

    public MovementMoney saveMovement(MovementMoney movement_param) {
        return movementRepository.save(movement_param);
    }

    public MovementMoney putMovement(MovementMoney movement_param) {
        return movementRepository.save(movement_param);
    }

}

