package com.techmind.enterprise.Controller.Frontend;

import com.techmind.enterprise.Model.Profile;
import com.techmind.enterprise.Services.ProfileService;
import com.techmind.enterprise.Services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.web.authentication.logout.SecurityContextLogoutHandler;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@Controller
public class HomeController {

    @Autowired
    ProfileService profileService;

    @Autowired
    UserService userService;

    @GetMapping("/")
    public String getIndex() {
        return "login";
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

    @RequestMapping(value="/logout", method = RequestMethod.GET)
    public String logoutPage (HttpServletRequest request, HttpServletResponse response) {
        Authentication auth = SecurityContextHolder.getContext().getAuthentication();
        if (auth != null){
            new SecurityContextLogoutHandler().logout(request, response, auth);
        }
        return "redirect:/login?logout";
    }
}
