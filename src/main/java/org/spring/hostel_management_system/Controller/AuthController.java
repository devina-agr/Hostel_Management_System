package org.spring.hostel_management_system.Controller;

import org.spring.hostel_management_system.DTO.AuthRequest;
import org.spring.hostel_management_system.DTO.AuthResponse;
import org.spring.hostel_management_system.DTO.StudentRegisterRequest;
import org.spring.hostel_management_system.Service.AuthService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/auth")
public class AuthController {

    private final AuthService authService;

     public AuthController(AuthService authService) {
        this.authService = authService;
     }

     @PostMapping("/login")
     public ResponseEntity<AuthResponse> login(@RequestBody AuthRequest authRequest){
            return ResponseEntity.ok(authService.login(authRequest));
     }

     @PostMapping("/register")
     public ResponseEntity<AuthResponse> register(@RequestBody StudentRegisterRequest request){
         return ResponseEntity.ok(authService.register(request));
     }

}
