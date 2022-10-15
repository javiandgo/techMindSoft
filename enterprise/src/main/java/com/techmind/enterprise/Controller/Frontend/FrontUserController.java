package com.techmind.enterprise.Controller.Frontend;

import com.techmind.enterprise.Model.Employee;
import com.techmind.enterprise.Model.Profile;
import com.techmind.enterprise.Model.Response;
import com.techmind.enterprise.Model.RoleName;
import com.techmind.enterprise.Services.EnterpriseService;
import com.techmind.enterprise.Services.ProfileService;
import com.techmind.enterprise.Services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
public class FrontUserController {

    @Autowired
    UserService userService;

    @Autowired
    ProfileService profileService;

    @Autowired
    EnterpriseService enterpriseService;

    @GetMapping("/users")
    public String getUsers (Model model) {
        model.addAttribute("usuarios", userService.getEmployees());
        return "users";
    }

    @GetMapping("/users/add")
    public String addUser(Model model) {
        model.addAttribute("formAddUser", new Employee());
        model.addAttribute("profiles", profileService.getProfiles());
        model.addAttribute("empresas", enterpriseService.getEnterprises());
        model.addAttribute("roles", RoleName.values());
        return "add-user";
    }

    @PostMapping("/users/added")
    public String postUser(@ModelAttribute("formAddUser") Employee employee){
        userService.saveEmployee(employee);
        return "redirect:/users";
    }

    @DeleteMapping("/users/delete/{id}")
    public String deleteUser(@PathVariable Long id) {
        userService.deleteEmployee(id);
        return "redirect:/users";
    }

}
