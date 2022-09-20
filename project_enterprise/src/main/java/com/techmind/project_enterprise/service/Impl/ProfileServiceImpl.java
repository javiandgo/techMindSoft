package com.techmind.project_enterprise.service.Impl;

import com.techmind.project_enterprise.model.Profile;
import com.techmind.project_enterprise.repository.IGenericRepository;
import com.techmind.project_enterprise.repository.IProfileRepository;
import com.techmind.project_enterprise.service.IProfileService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProfileServiceImpl implements IProfileService {
    @Autowired
    private IProfileRepository profilerepo;

    @Override
    public List<Profile> getAllProfiles() {
        return profilerepo.findAll();
    }

    @Override
    public Profile saveProfile(Profile profile) {
        return profilerepo.save(profile);
    }


    @Override
    public Profile getProfileById(Integer id) {

        return profilerepo.findById(id).get();
    }

    @Override
    public Profile updateProfile(Profile profile) {
        return profilerepo.save(profile);
    }

    @Override
    public void deleteProfileById(Integer id) {

        profilerepo.deleteById(id);
    }
}
