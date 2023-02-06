package com.end.beck.desafio.imedback.Model.DTO;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class AccountCredentialsDTO {

    private String username;
	private String password;

}