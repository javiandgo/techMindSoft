package com.techmind.enterprise.Services;

import com.techmind.enterprise.Model.Enterprise;
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

    public List<MovementMoney> getMovements() {
        return movementRepository.findAll();
    }

    public MovementMoney getMovements(Long id) throws Exception {
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

    public MovementMoney patchMovement(MovementMoney movement_param, Long id) throws Exception {
        try {
            MovementMoney movementBD = getMovements(id);

            if(movement_param.getAmountMovement() != null) {
                movementBD.setAmountMovement(movement_param.getAmountMovement());
            }

            if (movement_param.getDetailMovement() != null) {
                movementBD.setDetailMovement(movement_param.getDetailMovement());
            }

            if (movement_param.getUserOwner() != null){
                movementBD.setUserOwner(movement_param.getUserOwner());
            }

            return saveMovement(movementBD);

        } catch (Exception e) {
            throw new Exception("Movimiento no se actualizo, porque no existe");
        }
    }

    public String deleteMovement(Long id) {
        movementRepository.deleteById(id);
        return "Movimiento Eliminado Exitosamente";
    }

}

