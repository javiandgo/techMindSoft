package com.techmind.enterprise.Services;

import com.techmind.enterprise.Model.MyUserDetails;
import com.techmind.enterprise.Model.Profile;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
public class MyUserDetailService implements UserDetailsService {

    @Autowired
    ProfileService profileService;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {

        Profile profile = null;
        try {
             profile = profileService.getProfileUsername(username);
        } catch (Exception e) {
            e.printStackTrace();
            throw new UsernameNotFoundException(e.getMessage());
        }
        return new MyUserDetails(profile);
    }
}
