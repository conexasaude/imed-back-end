package com.end.beck.desafio.imedback.Exception;

import org.springframework.http.HttpStatus;
import org.springframework.security.core.AuthenticationException;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.FORBIDDEN)
public class InvalidJWTAuthentication extends AuthenticationException {

    public InvalidJWTAuthentication(String exception) {
        super(exception);
       
    }
    

}
