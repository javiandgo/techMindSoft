package com.techmind.enterprise.Controller;

import com.techmind.enterprise.Model.Enterprise;
import com.techmind.enterprise.Model.MovementMoney;
import com.techmind.enterprise.Model.Response;
import com.techmind.enterprise.Services.MovementService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class MovementController {
    
    @Autowired
    private MovementService movementService;
    
    @GetMapping("/enterprises/{id}/movements")
    public ResponseEntity<Object> getMovement(@PathVariable Long id) {
        try {
            MovementMoney movementMoney = movementService.getMovements(id);
            return new ResponseEntity<>(movementMoney, HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(e.getMessage(),
                    HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }


    @PostMapping("/enterprises/movement")
    public ResponseEntity<Response> postMovement(@RequestBody MovementMoney movementMoney) {
        return new ResponseEntity<>(
                new Response("Movimiento agregado exitosamente",
                        movementService.saveMovement(movementMoney)),
                HttpStatus.OK);
    }


    @PatchMapping("/enterprises/{id}/movements")
    public ResponseEntity<Response> patchMovement(@RequestBody MovementMoney movementMoney, @PathVariable Long id) {
        try {
            return new ResponseEntity<>(
                    new Response("Actualización Exitosa", movementService.patchMovement(movementMoney, id)),
                    HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(
                    new Response(e.getMessage(), null),
                    HttpStatus.OK);
        }
    }

    @DeleteMapping("enterprises/{id}/movements")
    public ResponseEntity<Response> deleteMovement(@PathVariable Long id) {
        return new ResponseEntity<>(
                new Response(movementService.deleteMovement(id), null),
                HttpStatus.OK
        );
    }
}
