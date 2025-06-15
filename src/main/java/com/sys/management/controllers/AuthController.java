package com.sys.management.controllers;

import com.sys.management.dto.AuthRequest;
import com.sys.management.dto.AuthResponse;
import com.sys.management.dto.RegisterDto;
import com.sys.management.dto.ReponseDto;
import com.sys.management.entities.MUser;
import com.sys.management.services.jwt.JwtService;
import com.sys.management.services.muser.MUserService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/auth")
@RequiredArgsConstructor
public class AuthController {
    private AuthenticationManager authManager;
    private final MUserService mUserService;
    private final JwtService jwtService;

    @PostMapping("/register")
    public ResponseEntity<ReponseDto> register(@RequestBody RegisterDto request) {
        mUserService.register(request);
        ReponseDto resp = new ReponseDto();
        resp.setMessage("Success");
        return ResponseEntity.ok(resp);
    }

    @PostMapping("/login")
    public ResponseEntity<AuthResponse> login(@RequestBody AuthRequest request) {
        Authentication authentication = authManager.authenticate(
                new UsernamePasswordAuthenticationToken(request.getUsername(), request.getPassword())
        );

        MUser user = (MUser) authentication.getPrincipal();
        String token = jwtService.generateToken(user);
        AuthResponse resp = new AuthResponse();
        resp.setToken(token);
        return ResponseEntity.ok(resp);
    }
}
