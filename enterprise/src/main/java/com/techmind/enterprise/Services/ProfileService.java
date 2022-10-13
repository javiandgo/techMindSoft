package com.techmind.enterprise.Services;

import com.techmind.enterprise.Model.Profile;
import com.techmind.enterprise.Repository.ProfileRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ProfileService {

    @Autowired
    private ProfileRepository profileRepository;

    public List<Profile> getProfiles() {
        return profileRepository.findAll();
    }

    public Profile getProfile(Long id) throws Exception {
        Optional<Profile> profileOptional = profileRepository.findById(id);
        if(profileOptional.isPresent()) {
            return profileOptional.get();
        }else {
            throw new Exception("Perfil No Existe");
        }
    }
    public Profile getProfileUsername(String username) {
        Profile profileOptional = profileRepository.findByUsername(username);
        return profileOptional;
    }

    public Profile saveProfile(Profile profile_param) {
        return profileRepository.save(profile_param);
    }

    public Profile putProfile(Profile profile_param) {
        return profileRepository.save(profile_param);
    }

    public Profile patchProfile(Profile profile_param, Long id) throws Exception {
        try {
            Profile profileBD = getProfile(id);

            if(profile_param.getUsername()!= null) {
                profileBD.setUsername(profile_param.getUsername());
            }

            if(profile_param.getPassword() != null) {
                profileBD.setPassword(profile_param.getPassword());
            }

            if(profile_param.getImage() != null) {
                profileBD.setImage(profile_param.getImage());
            }

            if (profile_param.getPhone() != null){
                profileBD.setPhone(profile_param.getPhone());
            }

            return saveProfile(profileBD);

        } catch (Exception e) {
            throw new Exception("Perfil no se actualizo, porque no existe");
        }
    }

    public String deleteProfile(Long id) {
        profileRepository.deleteById(id);
        return "Perfil Eliminado Exitosamente";
    }
}
