package org.spring.hostel_management_system.Config;

import jakarta.servlet.FilterChain;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.spring.hostel_management_system.Model.UserPrincipal;
import org.spring.hostel_management_system.Service.JwtService;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;
import org.springframework.security.web.authentication.WebAuthenticationDetailsSource;
import org.springframework.stereotype.Component;
import org.springframework.web.filter.OncePerRequestFilter;

import java.io.IOException;
import java.util.stream.Collectors;

@Component
public class JwtFilters extends OncePerRequestFilter {

    private final JwtService jwtService;
    private final UserDetailsService userDetailsService;

    public JwtFilters(JwtService jwtService, UserDetailsService userDetailsService) {
        this.jwtService = jwtService;
        this.userDetailsService = userDetailsService;
    }

    @Override
    protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain filterChain) throws ServletException, IOException {
        String path=request.getServletPath();
        if(path.contains("/auth")){
            filterChain.doFilter(request,response);
            return;
        }
        System.out.println("Incoming path: "+ request.getServletPath());
        System.out.println("Path: " + request.getServletPath());
        System.out.println("Header: " + request.getHeader(HttpHeaders.AUTHORIZATION));
        System.out.println("Authenticated user: " + SecurityContextHolder.getContext().getAuthentication());


        final String header=request.getHeader(HttpHeaders.AUTHORIZATION);
        if(header!=null &&  header.startsWith("Bearer ")){
            final String token=header.substring(7);
           try{
                if(jwtService.validateToken(token)){
                    final String email=jwtService.extractEmail(token);
                    var roles = jwtService.extractRoles(token);
                    var userDetails=userDetailsService.loadUserByUsername(email);
                    UserPrincipal userPrincipal=(UserPrincipal)userDetails;
//                    var auth=new UsernamePasswordAuthenticationToken(userPrincipal,null,userPrincipal.getAuthorities());
//                    auth.setDetails(new WebAuthenticationDetailsSource().buildDetails(request));
//                    SecurityContextHolder.getContext().setAuthentication(auth);
//                    System.out.println("Token value: " + token);
                    var authorities = roles.stream()
                            .map(role -> new SimpleGrantedAuthority(role.name()))
                            .collect(Collectors.toList());

                    var auth = new UsernamePasswordAuthenticationToken(userPrincipal, null, authorities);
                    auth.setDetails(new WebAuthenticationDetailsSource().buildDetails(request));

                    SecurityContextHolder.getContext().setAuthentication(auth);
                    System.out.println("✅ Authenticated user set: " + email);
                    System.out.println("Authenticated user: " + SecurityContextHolder.getContext().getAuthentication());
                }
           }
           catch (Exception e){
               System.out.println("Invalid token: " + e.getMessage());
               response.setStatus(HttpServletResponse.SC_UNAUTHORIZED);
               return;
           }
        }
        filterChain.doFilter(request, response);
    }
}
