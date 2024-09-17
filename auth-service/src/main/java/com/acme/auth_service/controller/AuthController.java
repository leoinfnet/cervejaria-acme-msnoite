package com.acme.auth_service.controller;

import com.acme.auth_service.payload.LoginRequest;
import com.acme.auth_service.payload.ResponsePayload;
import com.acme.auth_service.service.AuthService;
import com.acme.auth_service.service.UserService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController@RequestMapping("/")
@RequiredArgsConstructor
@Slf4j
public class AuthController {
    private final UserService userService;
    private final AuthService authService;
    @PostMapping("/auth")
    public ResponseEntity<?> auth(@RequestBody LoginRequest loginRequest){
        return ResponseEntity.ok(new ResponsePayload( authService.authenticate(loginRequest)));
    }
}
