package net.lakhwan.basic_auth.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class RegisterDto {
    private String username;
    private String first_name;
    private String last_name;
    private String password;
    private String email;
    private Boolean gender;
}
