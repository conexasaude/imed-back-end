package com.end.beck.desafio.imedback.Model.DTO;

import lombok.Data;

@Data
public class InsuranceDTO {
    
    private Long id;
    private String name;
    private String cnpj;
    private long price;

}
