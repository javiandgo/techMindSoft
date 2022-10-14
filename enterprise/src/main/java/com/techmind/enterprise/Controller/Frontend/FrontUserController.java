package com.techmind.enterprise.Controller.Frontend;

import com.techmind.enterprise.Model.Response;
import com.techmind.enterprise.Services.ProfileService;
import com.techmind.enterprise.Services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;

@Controller
public class FrontUserController {

    @Autowired
    UserService userService;

    @Autowired
    ProfileService profileService;

    @DeleteMapping("/delete/user/{id}")
    public String deleteUser(@PathVariable Long id) {
        userService.deleteEmployee(id);
        profileService.deleteProfile(id);
        return "redirect:/dashboard";
    }

}
