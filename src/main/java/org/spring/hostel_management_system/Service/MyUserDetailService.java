package org.spring.hostel_management_system.Service;

import org.spring.hostel_management_system.Model.User;
import org.spring.hostel_management_system.Model.UserPrincipal;
import org.spring.hostel_management_system.Repository.UserRepo;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
public class MyUserDetailService implements UserDetailsService {

    private final UserRepo userRepo;

    public MyUserDetailService(UserRepo userRepo) {
        this.userRepo = userRepo;
    }
    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        User user=userRepo.findByEmail(username);
        if(user==null){
            throw new RuntimeException("User not found!");
        }
        return new UserPrincipal(user);
    }
}
