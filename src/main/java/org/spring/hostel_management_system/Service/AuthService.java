package org.spring.hostel_management_system.Service;

import org.spring.hostel_management_system.DTO.AuthRequest;
import org.spring.hostel_management_system.DTO.AuthResponse;
import org.spring.hostel_management_system.DTO.StudentRegisterRequest;
import org.spring.hostel_management_system.Model.Role;
import org.spring.hostel_management_system.Model.User;
import org.spring.hostel_management_system.Repository.UserRepo;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.Set;

@Service
public class AuthService {
    private final AuthenticationManager authenticationManager;
    private final UserRepo userRepo;
    private final JwtService jwtService;
    private final PasswordEncoder passwordEncoder;

    public AuthService(AuthenticationManager authenticationManager, UserRepo userRepo, JwtService jwtService, PasswordEncoder passwordEncoder) {
        this.authenticationManager = authenticationManager;
        this.userRepo = userRepo;
        this.jwtService = jwtService;
        this.passwordEncoder = passwordEncoder;
    }

    public AuthResponse login(AuthRequest authRequest) {
        authenticationManager.authenticate(
                new UsernamePasswordAuthenticationToken(
                        authRequest.getEmail(),
                        authRequest.getPassword()
                )
        );
        User user=userRepo.findByEmail(authRequest.getEmail());
        if(user==null){
            throw new RuntimeException("User not found!");
        }
        String token= jwtService.generateToken(user.getEmail(), user.getRole());
        return new AuthResponse(user.getEmail(),token,user.getRole());
    }

    public AuthResponse register(StudentRegisterRequest request) {
        if(userRepo.findByEmail(request.getEmail())!=null){
            throw new RuntimeException("Email already exists!");
        }
        User student=new User();
        student.setEmail(request.getEmail());
        student.setName(request.getName());
        student.setContactNo(request.getContactNo());
        student.setPassword(passwordEncoder.encode(request.getPassword()));
        student.setRole(Set.of(Role.ROLE_STUDENT));
        userRepo.save(student);
        String token=jwtService.generateToken(student.getEmail(),student.getRole());
        return new AuthResponse(student.getEmail(),token,student.getRole());
    }
}
