package com.techmind.enterprise.Controller.Frontend;

import com.techmind.enterprise.Model.Employee;
import com.techmind.enterprise.Model.RoleName;
import com.techmind.enterprise.Services.EnterpriseService;
import com.techmind.enterprise.Services.ProfileService;
import com.techmind.enterprise.Services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
public class UsersController {

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

    @GetMapping("/users/add-new")
    public String addUser(Model model) {
        model.addAttribute("formAddUser", new Employee());
        model.addAttribute("profiles", profileService.getProfiles());
        model.addAttribute("empresas", enterpriseService.getEnterprises());
        model.addAttribute("roles", RoleName.values());
        return "add-user";
    }
    @GetMapping("/users/update/{id}")
    public String getUser(Model model, @PathVariable Long id) {
        try {
            model.addAttribute("updateUser", userService.getEmployee(id));
            model.addAttribute("profiles", profileService.getProfiles());
            model.addAttribute("empresas", enterpriseService.getEnterprises());
            model.addAttribute("roles", RoleName.values());
            return "update-user";
        } catch (Exception e) {
            return "redirect:/error";
        }


    }

    @PostMapping("/users/add")
    public String postUser(@ModelAttribute("formAddUser") Employee employee){
        userService.saveEmployee(employee);
        return "redirect:/users";
    }

    @PatchMapping("/users/update/{id}")
    public String patchUser(@ModelAttribute("updateUser") Employee employee, @PathVariable Long id) {
        try {
            userService.patchEmployee(employee, id);
            return "redirect:/users";
        } catch (Exception e) {
            return "redirect:/error";
        }
    }

    @DeleteMapping("/users/delete/{id}")
    public String deleteUser(@PathVariable Long id) {
        userService.deleteEmployee(id);
        return "redirect:/users";
    }

}
