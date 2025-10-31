package org.spring.hostel_management_system.DTO;

import org.spring.hostel_management_system.Model.Role;

import java.util.Set;

public class AuthResponse {
    private String email;
    private String token;
    private Set<Role> role;

    public AuthResponse(String email, String token, Set<Role> role) {
        this.email = email;
        this.token = token;
        this.role = role;
    }

    public AuthResponse(String token) {
        this.token=token;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getToken() {
        return token;
    }

    public void setToken(String token) {
        this.token = token;
    }

    public Set<Role> getRole() {
        return role;
    }

    public void setRole(Set<Role> role) {
        this.role = role;
    }
}
