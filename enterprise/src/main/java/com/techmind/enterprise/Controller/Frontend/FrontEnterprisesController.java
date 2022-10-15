package com.techmind.enterprise.Controller.Frontend;

import com.techmind.enterprise.Model.Enterprise;
import com.techmind.enterprise.Services.EnterpriseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

public class FrontEnterprisesController {

    @Autowired
    EnterpriseService enterpriseService;

    @GetMapping("/enterprises")
    public String getEnterprises(Model model) {
        model.addAttribute("empresas", enterpriseService.getEnterprises());
        return "enterprises";
    }


    @DeleteMapping("/enterprises/delete/{id}")
    public String deleteUser(@PathVariable Long id) {
        enterpriseService.deleteEnterprise(id);
        return "redirect:/dashboard";
    }
}


