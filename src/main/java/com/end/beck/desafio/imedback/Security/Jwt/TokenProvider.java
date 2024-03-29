package com.end.beck.desafio.imedback.Security.Jwt;

import java.util.Base64;
import java.util.Date;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import com.auth0.jwt.JWT;
import com.auth0.jwt.JWTVerifier;
import com.auth0.jwt.algorithms.Algorithm;
import com.auth0.jwt.interfaces.DecodedJWT;
import com.end.beck.desafio.imedback.Exception.InvalidJWTAuthentication;
import com.end.beck.desafio.imedback.Model.DTO.TokenDTO;

public class TokenProvider {

    @Value("${security.jwt.token.secret-key:secret}")
	private String secretKey = "secret";
	
	@Value("${security.jwt.token.expire-length:3600000}")
	private long validityInMilliseconds = 3600000; // 1h

    private long time = 3;

    @Autowired
    private UserDetailsService  userDetailsService;

    Algorithm algorithm = null;

    @PostConstruct
    protected void init() {
        secretKey = Base64.getEncoder().encodeToString(secretKey.getBytes());
        algorithm = Algorithm.HMAC256(secretKey.getBytes());

    }
    
    public TokenDTO createAccessTokenVO(String username, List<String> roles) {
        
        Date now = new Date();
        Date validity = new Date(now.getTime() + validityInMilliseconds);
        var acessToken = getAcessToken(username, roles ,now ,validity);
        var refreshToken = getRefreshToken(username, roles, now);
        
        return new TokenDTO(username ,true ,now ,validity ,acessToken ,refreshToken);
    }
    
    private String getAcessToken(String username, List<String> roles, Date now, Date validity) {
        String issuesrURL =   ServletUriComponentsBuilder.fromCurrentContextPath().build().toUriString();
        return JWT.create()
                .withClaim("roles", roles)
                .withIssuedAt(now)
                .withExpiresAt(validity)
                .withSubject(issuesrURL)
                .sign(algorithm)
                .strip();
    }

    private String getRefreshToken(String username, List<String> roles, Date now) {
        
        Date validityRefreshToken = new Date(now.getTime() + validityInMilliseconds * time);
        
        return JWT.create()
        .withClaim("roles", roles)
        .withIssuedAt(now)
        .withExpiresAt(validityRefreshToken)
        .sign(algorithm)
        .strip();
    }

    public Authentication getAuthentication(String token) {

        DecodedJWT decodedJWT = decodedToken(token);
        UserDetails userDetails = this.userDetailsService.loadUserByUsername(decodedJWT.getSubject());

        return new UsernamePasswordAuthenticationToken(userDetails,"",  userDetails.getAuthorities());

    }

    private DecodedJWT decodedToken(String token) {
        
        Algorithm alg = Algorithm.HMAC256(secretKey.getBytes());
        JWTVerifier verifier = JWT.require(alg).build();
        DecodedJWT decodedJWT = verifier.verify(token);

        
        return null;
    }

    public String resolveToken(HttpServletRequest request) {
        
        String bearerToken = request.getHeader("Authorization");

        if(bearerToken != null &&  bearerToken.startsWith("Bearer ")) {
            return bearerToken.substring("Bearer ".length());
        }
        
        return null;
    }

    public boolean validationToken(String token) {
        DecodedJWT decodedJWT = decodedToken(token);
        try {
            if(decodedJWT.getExpiresAt().before(new Date())) {
                return false;
            }
            return true;
        } catch (Exception e) {
          throw new InvalidJWTAuthentication("token expirando ou invalid JWT token");
        }

    }

}
