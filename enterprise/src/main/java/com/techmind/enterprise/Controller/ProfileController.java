package com.techmind.enterprise.Controller;

import com.techmind.enterprise.Model.Profile;
import com.techmind.enterprise.Model.Response;
import com.techmind.enterprise.Services.ProfileService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class ProfileController {

    @Autowired
    private ProfileService profileService;
    @GetMapping("/profiles")
    public ResponseEntity<List<Profile>> getProfiles() {

        return new ResponseEntity<List<Profile>>(
                profileService.getProfiles(),
                HttpStatus.OK
        );
    }

    @GetMapping("/profile/{id}")
    public ResponseEntity<Object> getProfile(@PathVariable Long id) {

        try {
            Profile profile = profileService.getProfile(id);
            return new ResponseEntity<>(profile, HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(e.getMessage(),
                    HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @GetMapping("/profile")
    public ResponseEntity<Object> getProfiles(@RequestParam Long id) {
        try {
            Profile profile = profileService.getProfile(id);
            return new ResponseEntity<>(profile, HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(e.getMessage(),
                    HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @PostMapping("/profiles")
    public ResponseEntity<Response> postProfile(@RequestBody Profile profile) {
        return new ResponseEntity<>(
                new Response("Perfil creada exitosamente",
                profileService.saveProfile(profile)),
                HttpStatus.OK);
    }

    @PutMapping("/profile")
    public ResponseEntity<Response> putProfile(@RequestBody Profile profile) {
        return new ResponseEntity<>(
                new Response("Empresa Actualizada Exitosamente",
                        profileService.putProfile(profile))
                ,HttpStatus.OK);
    }

    @PatchMapping("/profile/{id}")
    public ResponseEntity<Response> patchProfile(@RequestBody Profile profile, @PathVariable Long id) {
        try {
            return new ResponseEntity<>(
                    new Response("Actualización Exitosa", profileService.patchProfile(profile, id)),
                    HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(
                    new Response(e.getMessage(), null),
                    HttpStatus.OK);
        }
    }

    @DeleteMapping("profile/{id}")
    public ResponseEntity<Response> deleteProfile(@PathVariable Long id) {
        return new ResponseEntity<>(
                new Response(profileService.deleteProfile(id), null),
                HttpStatus.OK
        );
    }
}
