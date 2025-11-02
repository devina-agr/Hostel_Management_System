package org.spring.hostel_management_system.Config;

import org.spring.hostel_management_system.Service.MyUserDetailService;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpStatus;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.authentication.dao.DaoAuthenticationProvider;
import org.springframework.security.config.annotation.authentication.configuration.AuthenticationConfiguration;
import org.springframework.security.config.annotation.method.configuration.EnableMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;
import org.springframework.stereotype.Component;

@Configuration
@EnableMethodSecurity
public class SecurityConfig {

    private final JwtFilters jwtFilters;
    private final MyUserDetailService myUserDetailService;

    public SecurityConfig(JwtFilters jwtFilters, MyUserDetailService myUserDetailService) {
        this.jwtFilters = jwtFilters;
        this.myUserDetailService = myUserDetailService;
    }

        @Bean
        public SecurityFilterChain filterChain(HttpSecurity http, AuthenticationProvider authenticationProvider) throws Exception{

            http.csrf(customizer->customizer.disable())
                    .sessionManagement((s)->s.sessionCreationPolicy(SessionCreationPolicy.STATELESS))
                    .authorizeHttpRequests(auth->auth
                            .requestMatchers("/api/auth/login","/api/auth/register").permitAll()
                            .requestMatchers("/api/staff/**").hasAuthority("ROLE_STAFF")
                            .requestMatchers("/api/warden/**").hasAuthority("ROLE_WARDEN")
                            .requestMatchers("/api/student/**").hasAuthority("ROLE_STUDENT")
                            .anyRequest().authenticated()
                    );
            http
                    .authenticationProvider(daoAuthenticationProvider())
                    .addFilterBefore(jwtFilters, UsernamePasswordAuthenticationFilter.class);
            return http.build();
        }

    @Bean
    public PasswordEncoder passwordEncoder(){
        return new BCryptPasswordEncoder();
    }

    @Bean
    public AuthenticationProvider daoAuthenticationProvider() {
        DaoAuthenticationProvider daoAuthenticationProvider=new DaoAuthenticationProvider();
        daoAuthenticationProvider.setUserDetailsService(myUserDetailService);
        daoAuthenticationProvider.setPasswordEncoder(passwordEncoder());

        return daoAuthenticationProvider;
    }



    @Bean
    public AuthenticationManager authenticationManager(AuthenticationConfiguration config) throws Exception{
        return config.getAuthenticationManager();
    }


}
