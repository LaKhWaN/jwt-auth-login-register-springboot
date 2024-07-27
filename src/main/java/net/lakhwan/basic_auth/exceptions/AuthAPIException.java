package net.lakhwan.basic_auth.exceptions;

import lombok.AllArgsConstructor;
import lombok.Getter;
import org.springframework.http.HttpStatus;

@Getter
@AllArgsConstructor
public class AuthAPIException extends RuntimeException {
    private HttpStatus status;
    private String message;
}
