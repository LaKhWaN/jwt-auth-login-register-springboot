package net.lakhwan.basic_auth.service.impl;

import lombok.AllArgsConstructor;
import net.lakhwan.basic_auth.dto.LoginDto;
import net.lakhwan.basic_auth.dto.RegisterDto;
import net.lakhwan.basic_auth.entity.User;
import net.lakhwan.basic_auth.entity.Role;
import net.lakhwan.basic_auth.exceptions.AuthAPIException;
import net.lakhwan.basic_auth.repository.RoleRepository;
import net.lakhwan.basic_auth.repository.UserRepository;
import net.lakhwan.basic_auth.security.JwtTokenProvider;
import net.lakhwan.basic_auth.service.AuthService;
import org.springframework.http.HttpStatus;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.HashSet;
import java.util.Set;

@Service
@AllArgsConstructor
public class AuthServiceImpl implements AuthService {

    private UserRepository userRepository;
    private RoleRepository roleRepository;
    private PasswordEncoder passwordEncoder;
    private AuthenticationManager authenticationManager;
    private JwtTokenProvider jwtTokenProvider;

    @Override
    public String register(RegisterDto registerDto) {

        if(userRepository.existsByUsername(registerDto.getUsername())){
            throw new AuthAPIException(HttpStatus.BAD_REQUEST, "Username already exists");
        }

        User user = new User();
        user.setUsername(registerDto.getUsername());
        user.setFirst_name(registerDto.getFirst_name());
        user.setLast_name(registerDto.getLast_name());
        user.setPassword(passwordEncoder.encode(registerDto.getPassword()));
        user.setEmail(registerDto.getEmail());
        user.setGender(registerDto.getGender());

        Set<Role> roles = new HashSet<>();
        Role userRole = roleRepository.findByName("USER");
        roles.add(userRole);

        user.setRoles(roles);

        userRepository.save(user);

        return "User Registered Successfully!";
    }

    @Override
    public String login(LoginDto loginDto) {

            Authentication authentication = authenticationManager.authenticate(
                    new UsernamePasswordAuthenticationToken(
                            loginDto.getUsername(),
                            loginDto.getPassword()
                    )
            );

            SecurityContextHolder.getContext().setAuthentication(authentication);

            return jwtTokenProvider.generateToken(authentication);
    }
}
