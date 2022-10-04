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
    
    @GetMapping("/movements")
    public ResponseEntity<List<MovementMoney>> getMovements() {
        
        return new ResponseEntity<List<MovementMoney>>(
                movementService.getMovements(),
                HttpStatus.OK
        );
    }
    
    @GetMapping("/movement/{id}")
    public ResponseEntity<Object> getMovement(@PathVariable Long id) {
        try {
            MovementMoney movementMoney = movementService.getMovements(id);
            return new ResponseEntity<>(movementMoney, HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(e.getMessage(),
                    HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @GetMapping("/movement")
    public ResponseEntity<Object> getMovements(@RequestParam Long id) {
        try {
            MovementMoney movementMoney = movementService.getMovements(id);
            return new ResponseEntity<>(movementMoney, HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(e.getMessage(),
                    HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @PostMapping("/movement")
    public ResponseEntity<Response> postMovement(@RequestBody MovementMoney movementMoney) {
        return new ResponseEntity<>(
                new Response("Empresa creada exitosamente",
                        movementService.saveMovement(movementMoney)),
                HttpStatus.OK);
    }

    @PutMapping("/movement")
    public ResponseEntity<Response> putMovement(@RequestBody MovementMoney movementMoney) {
        return new ResponseEntity<>(
                new Response("Empresa Actualizada Exitosamente",
                        movementService.putMovement(movementMoney))
                ,HttpStatus.OK);
    }

    @PatchMapping("/movement")
    public ResponseEntity<Response> patchMovement(@RequestBody MovementMoney movementMoney) {
        try {
            return new ResponseEntity<>(
                    new Response("Actualización Exitosa", movementService.patchMovement(movementMoney)),
                    HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(
                    new Response(e.getMessage(), null),
                    HttpStatus.OK);
        }
    }

    @DeleteMapping("movement/{id}")
    public ResponseEntity<Response> deleteMovement(@PathVariable Long id) {
        return new ResponseEntity<>(
                new Response(movementService.deleteMovement(id), null),
                HttpStatus.OK
        );
    }
}
