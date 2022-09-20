package com.techmind.project_enterprise.service;

import com.techmind.project_enterprise.model.Profile;

import java.util.List;

public interface IProfileService  {
    List<Profile> getAllProfiles();
     Profile saveProfile (Profile profile);
    Profile getProfileById(Integer id);
    Profile updateProfile(Profile profile);
    void deleteProfileById(Integer id);
}
