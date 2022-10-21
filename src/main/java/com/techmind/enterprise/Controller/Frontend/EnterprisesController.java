package com.techmind.enterprise.Controller.Frontend;

import com.techmind.enterprise.Model.Enterprise;
import com.techmind.enterprise.Services.EnterpriseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
public class EnterprisesController {

    @Autowired
    EnterpriseService enterpriseService;

    @GetMapping("/enterprises")
    public String getEnterprises(Model model) {
        model.addAttribute("empresas", enterpriseService.getEnterprises());
        return "enterprises";
    }

    @GetMapping("/enterprises/add-new")
    public String addEnterprise(Model model) {
        model.addAttribute("formAddEnterprise", new Enterprise());
        return "add-enterprise";
    }

    @GetMapping("/enterprises/update/{id}")
    public String getEnterprise(Model model, @PathVariable Long id) {
        try {
            model.addAttribute("updateEnterprise", enterpriseService.getEnterprise(id));
            return "update-enterprise";
        } catch (Exception e) {
            return "redirect:/error";
        }
    }

    @PostMapping("/enterprises/add")
    public String postEnterprise(@ModelAttribute("formAddEnterprise") Enterprise enterprise){
        enterpriseService.saveEnterprise(enterprise);
        return "redirect:/enterprises";
    }

    @PatchMapping("/enterprises/update/{id}")
    public String patchEnterprise(@ModelAttribute("updateEnterprise") Enterprise enterprise, @PathVariable Long id) {
        try {
            enterpriseService.patchEnterprise(enterprise, id);
            return "redirect:/enterprises";
        } catch (Exception e) {
            return "redirect:/error";
        }
    }

    @DeleteMapping("/enterprises/delete/{id}")
    public String deleteEnterprise(@PathVariable Long id) {
        enterpriseService.deleteEnterprise(id);
        return "redirect:/enterprises";
    }
}


