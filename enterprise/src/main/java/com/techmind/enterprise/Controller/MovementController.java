package com.techmind.enterprise.Controller;

import com.techmind.enterprise.Model.MovementMoney;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class MovementController {
    @GetMapping
    public ResponseEntity<List<MovementMoney>> getMovements() {
        return null;
    }
}
