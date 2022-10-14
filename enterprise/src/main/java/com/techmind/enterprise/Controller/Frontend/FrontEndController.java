package com.techmind.enterprise.Controller.Frontend;

import com.techmind.enterprise.Model.Profile;
import com.techmind.enterprise.Services.ProfileService;
import com.techmind.enterprise.Services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class FrontEndController {

    @Autowired
    ProfileService profileService;

    @Autowired
    UserService userService;

    @GetMapping("/")
    public String getIndex() {
        return "dashboard";
    }


    @GetMapping("/login")
    public String getLogin (Model model) {

        model.addAttribute("formLogin", new Profile());
        return "login";
    }

    //@PostMapping("/login")
    //public String postLogin (Model model) {
    //    Profile profile = (Profile) model.getAttribute("formLogin");
    //}

    @PostMapping("/login")
    public String postLogin (@ModelAttribute("formLogin") Profile profile) {
        System.out.println(profile);
        return "redirect:/dashboard";
    }

    @GetMapping("/dashboard")
    public String getDashboard (Model model) {
        model.addAttribute("usuarios", userService.getEmployees());
        return "dashboard";
    }

    @GetMapping("/users")
    public String getUsers (Model model) {
        model.addAttribute("usuarios", userService.getEmployees());
        return "users";
    }
}
