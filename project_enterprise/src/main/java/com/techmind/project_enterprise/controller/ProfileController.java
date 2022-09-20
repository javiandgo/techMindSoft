package com.techmind.project_enterprise.controller;

import com.techmind.project_enterprise.dto.ProfileDTO;
import com.techmind.project_enterprise.exeptions.ModelNotFoundException;
import com.techmind.project_enterprise.model.Profile;
import com.techmind.project_enterprise.service.IProfileService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;
import java.util.stream.Collectors;

/*@RestController
@RequestMapping("/profiles")*/
@Controller
public class ProfileController {
    @Autowired
    private IProfileService service;

   /* @Autowired
    @Qualifier("profileMapper")
    private ModelMapper mapper;*/

    @GetMapping("/profiles")
    public String viewHomePage(Model model){
        model.addAttribute("profiles",service.getAllProfiles());
        return "profile/profiles";
    }
    @GetMapping("/profiles/nuevo")
    public String formularioRegistro(Model model){
        Profile profile = new Profile();
        model.addAttribute("profile",profile);
        return "profile/create_profile";
    }
    @PostMapping("/profiles")
    public String saveProfile(@ModelAttribute("profile")Profile profile){
        service.saveProfile(profile);
        return "redirect:/profiles";

    }
    @GetMapping("/profiles/editar/{id}")
    public  String formularioEditar(@PathVariable Integer id,Model model){
        model.addAttribute("profile",service.getProfileById(id));
        return "profile/edit_profile";
    }
    @PostMapping("profiles/{id}")
    public String updateProfiles(@PathVariable Integer id, @ModelAttribute("profile") Profile profile, Model model){
        Profile profileExistent = service.getProfileById(id);
        profileExistent.setIdProfile(id);
        profileExistent.setImage(profile.getImage());
        profileExistent.setPhone(profile.getPhone());
        profileExistent.setCreatedAt(profile.getCreatedAt());

        service.updateProfile(profileExistent);
        return "redirect:/profiles";
    }
    @GetMapping("/profiles/{id}")
    public String deleteProfile(@PathVariable Integer id){
        service.deleteProfileById(id);
        return "redirect:/profiles";
    }

}

