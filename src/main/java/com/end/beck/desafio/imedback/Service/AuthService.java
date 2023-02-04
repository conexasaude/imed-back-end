package com.end.beck.desafio.imedback.Service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.end.beck.desafio.imedback.Data.VO.AccountCredentialsVO;
import com.end.beck.desafio.imedback.Data.VO.TokenVO;
import com.end.beck.desafio.imedback.Repository.UserRepository;
import com.end.beck.desafio.imedback.Security.Jwt.JwtTokenProvider;


@Service
public class AuthService { 
    
    @Autowired
    private AuthenticationManager authenticationManager;

    @Autowired
    private JwtTokenProvider jwtTokenProvider;

    @Autowired
    private UserRepository userRepository;

    @SuppressWarnings("rawtypes")
    public ResponseEntity signin( AccountCredentialsVO data) {
        try {
            var username = data.getUsername();
			var password = data.getPassword();
            authenticationManager.authenticate(
                new UsernamePasswordAuthenticationToken(username, password)
            );
            var user = userRepository.findByUsername(username);
            var tokenReponse = new TokenVO();
            if (user != null) {
                tokenReponse = jwtTokenProvider.createAccessTokenVO(username, user.getRoles());              
            }else{
                throw new UsernameNotFoundException("usuário" + username + "não encontrado");
            }
            return ResponseEntity.ok(tokenReponse);

        } catch (Exception e) {
            throw new BadCredentialsException("usuário ou senha inválida");
        }
        
    }

   
}
