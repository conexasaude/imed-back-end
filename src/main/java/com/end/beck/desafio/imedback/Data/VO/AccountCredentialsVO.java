package com.end.beck.desafio.imedback.Data.VO;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class AccountCredentialsVO {

    private String username;
	private String password;

}