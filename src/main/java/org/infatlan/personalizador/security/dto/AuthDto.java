package org.infatlan.personalizador.security.dto;

import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.AllArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class AuthDto {
    
    private String token; 
    private String first_name; 
    private String last_name;
    private String country;
    private String branch;

}
