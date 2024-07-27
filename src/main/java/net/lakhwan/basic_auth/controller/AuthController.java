package net.lakhwan.basic_auth.controller;

import lombok.AllArgsConstructor;
import net.lakhwan.basic_auth.dto.JwtAuthResponse;
import net.lakhwan.basic_auth.dto.LoginDto;
import net.lakhwan.basic_auth.dto.RegisterDto;
import net.lakhwan.basic_auth.service.AuthService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@AllArgsConstructor
@CrossOrigin("*")
@RestController
@RequestMapping("/api/auth")
public class AuthController {

    private AuthService authService;

    @PostMapping("/register")
    public ResponseEntity<String> registerUser(@RequestBody RegisterDto registerDto){
        String response = authService.register(registerDto);

        return new ResponseEntity<>(response, HttpStatus.CREATED);
    }

    @PostMapping("/login")
    public ResponseEntity<JwtAuthResponse> loginUser(@RequestBody LoginDto loginDto){
        String token = authService.login(loginDto);

        JwtAuthResponse jwtAuthResponse = new JwtAuthResponse();
        jwtAuthResponse.setAccessToken(token);


        return ResponseEntity.ok(jwtAuthResponse);
    }
}
