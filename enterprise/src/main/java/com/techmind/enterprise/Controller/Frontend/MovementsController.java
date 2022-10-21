package com.techmind.enterprise.Controller.Frontend;


import com.techmind.enterprise.Model.Enterprise;
import com.techmind.enterprise.Model.MovementMoney;
import com.techmind.enterprise.Services.EnterpriseService;
import com.techmind.enterprise.Services.MovementService;
import com.techmind.enterprise.Services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
public class MovementsController {
    @Autowired
    MovementService movementService;

    @Autowired
    EnterpriseService enterpriseService;

    @Autowired
    UserService userService;

    @GetMapping("/transactions")
    public String getMovements(Model model) {
        model.addAttribute("movimientos", movementService.getMovements());
        model.addAttribute("empresas", enterpriseService.getEnterprises());
        return "movements";
    }

    @GetMapping("/enterprises/{id}/transactions")
    public String getMovementsByEnterprise(Model model, @PathVariable Long id) {
        model.addAttribute("id", id);
        model.addAttribute("movementsByEnterprise", movementService.getMovementMoneyByEnterpriseId(id));
        model.addAttribute("empresas", enterpriseService.getEnterprises());
        return "movements-by-enterprise";
    }

    @GetMapping("/transactions/enterprise")
    public String getTransactionsByEnterprise(Model model, @Param("id") Long id) {
        model.addAttribute("movementsByEnterprise", movementService.getMovementMoneyByEnterpriseId(id));
        model.addAttribute("empresas", enterpriseService.getEnterprises());
        return "movements-by-enterprise";
    }


    @GetMapping("/transactions/add-new")
    public String addEnterprise(Model model) {
        model.addAttribute("addTransaction", new MovementMoney());
        model.addAttribute("empresas", enterpriseService.getEnterprises());
        model.addAttribute("empleados", userService.getEmployees());
        return "add-movement";
    }

    @GetMapping("/transactions/update/{id}")
    public String getEnterprise(Model model, @PathVariable Long id) {
        try {
            model.addAttribute("updateTransaction", movementService.getMovement(id));
            model.addAttribute("empresas", enterpriseService.getEnterprises());
            model.addAttribute("empleados", userService.getEmployees());
            return "update-movement";
        } catch (Exception e) {
            return "redirect:/error";
        }
    }

    @PostMapping("/transactions/add")
    public String postMovement(@ModelAttribute("addTransaction") MovementMoney movement){
        movementService.saveMovement(movement);
        return "redirect:/transactions";
    }

    @PatchMapping("/transactions/update/{id}")
    public String patchMovement(@ModelAttribute("updateTransaction") MovementMoney movement, @PathVariable Long id) {
        try {
            movementService.patchMovement(movement, id);
            return "redirect:/transactions";
        } catch (Exception e) {
            return "redirect:/error";
        }
    }

    @DeleteMapping("/transactions/delete/{id}")
    public String deleteMovement(@PathVariable Long id) {
        movementService.deleteMovement(id);
        return "redirect:/transactions";
    }
}
