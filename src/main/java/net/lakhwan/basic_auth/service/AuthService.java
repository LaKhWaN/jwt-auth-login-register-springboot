package net.lakhwan.basic_auth.service;

import net.lakhwan.basic_auth.dto.LoginDto;
import net.lakhwan.basic_auth.dto.RegisterDto;

public interface AuthService {
    String register(RegisterDto registerDto);

    String login(LoginDto loginDto);
}
