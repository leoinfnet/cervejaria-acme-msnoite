package com.acme.auth_service.service;

import com.acme.auth_service.model.Role;
import com.acme.auth_service.model.User;
import com.acme.auth_service.payload.LoginRequest;
import com.acme.auth_service.payload.RegisterRequest;
import lombok.RequiredArgsConstructor;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

@Service
@RequiredArgsConstructor
public class AuthService {
    private final UserService userService;
    private final PasswordEncoder passwordEncoder;
    private final AuthenticationManager authenticationManager;
    private final JwtService jwtService;
    public User register(RegisterRequest registerRequest){
        User user = User.builder().name(registerRequest.firstName())
                .password(passwordEncoder.encode(registerRequest.password()))
                .lastName(registerRequest.lastName())
                .role(Role.USER).build();
        return userService.save(user);
    }
    public String authenticate(LoginRequest loginRequest){
        UsernamePasswordAuthenticationToken userAuth = new UsernamePasswordAuthenticationToken(loginRequest.email(), loginRequest.password());
        Authentication authenticate = authenticationManager.authenticate(userAuth);
        User usuarioAutenticado = (User) authenticate.getPrincipal();
        return jwtService.generateToken(usuarioAutenticado, getRoles(authenticate.getAuthorities()));

    }
    public List<String> getRoles(Collection<? extends GrantedAuthority> authorities){
        return authorities.stream().map(GrantedAuthority::getAuthority).toList();
    }

}
