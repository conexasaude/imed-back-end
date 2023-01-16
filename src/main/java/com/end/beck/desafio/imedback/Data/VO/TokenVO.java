package com.end.beck.desafio.imedback.Data.VO;

import java.util.Date;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class TokenVO {
    
    private String username;
    private boolean authentication;
    private Date created;
    private Date expiration;
    private String acessToken;
    private String refreshToken;

}
