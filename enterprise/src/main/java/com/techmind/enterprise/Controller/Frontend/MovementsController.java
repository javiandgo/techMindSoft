package com.techmind.enterprise.Controller.Frontend;


import com.techmind.enterprise.Model.Enterprise;
import com.techmind.enterprise.Model.MovementMoney;
import com.techmind.enterprise.Services.EnterpriseService;
import com.techmind.enterprise.Services.MovementService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
public class MovementsController {
    @Autowired
    MovementService movementService;

    @GetMapping("/transactions")
    public String getMovements(Model model) {
        model.addAttribute("movimientos", movementService.getMovements());
        return "movements";
    }

    @GetMapping("/transactions/{id}/enterprise")
    public String getMovementsByEnterprise(Model model, @PathVariable Long id) {
        model.addAttribute("movementsByEnterprise", movementService.getMovementMoneyByEnterpriseId(id));
        return "movements-by-enterprise";
    }

    @GetMapping("/transactions/add-new")
    public String addEnterprise(Model model) {
        model.addAttribute("formAddMovement", new Enterprise());
        return "add-movement";
    }

    @GetMapping("/transactions/update/{id}")
    public String getEnterprise(Model model, @PathVariable Long id) {
        try {
            model.addAttribute("updateMovement", movementService.getMovement(id));
            return "update-movements";
        } catch (Exception e) {
            return "redirect:/error";
        }
    }

    @PostMapping("/transaction/add")
    public String postMovement(@ModelAttribute("formAddMovement") MovementMoney movement){
        movementService.saveMovement(movement);
        return "redirect:/transactions";
    }

    @PatchMapping("/transaction/update/{id}")
    public String patchMovement(@ModelAttribute("updateMovement") MovementMoney movement, @PathVariable Long id) {
        try {
            movementService.patchMovement(movement, id);
            return "redirect:/transactions";
        } catch (Exception e) {
            return "redirect:/error";
        }
    }

    @DeleteMapping("/transaction/delete/{id}")
    public String deleteMovement(@PathVariable Long id) {
        movementService.deleteMovement(id);
        return "redirect:/transactions";
    }
}
