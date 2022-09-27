package org.infatlan.personalizador.security.util;

import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.AuthorityUtils;
import org.springframework.stereotype.Component;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;

@Component
public class JWTUtils {
    
    public static String getJWTToken(String username, String authorities) {

        List<GrantedAuthority> grantedAuthorities = AuthorityUtils
        .commaSeparatedStringToAuthorityList(authorities);
        
        String token = Jwts.
                        builder()
                        .setSubject(username)
                        .claim("authorities", 
                            grantedAuthorities.stream()
                                .map(GrantedAuthority::getAuthority)
                                .collect(Collectors.toList()))
                        .setIssuedAt(new Date(System.currentTimeMillis()))
                        .setExpiration(new Date(System.currentTimeMillis() + (60000 * 60)))
                        .signWith(SignatureAlgorithm.HS256, getSecretKey().getBytes()).compact();
		return "Bearer " + token;
	}

    public static String getSecretKey(){
        return "fB4,xS1^uA4_hQ6)lO9%zL8<gI9?oT9>";
    }

    public static Claims validateToken(String token) {

        String jwtToken = token.replace("Bearer ", "");
        return Jwts.parser().setSigningKey(getSecretKey().getBytes()).parseClaimsJws(jwtToken).getBody();
    
    }

    public static String refreshToken(String token){

        Claims claims = validateToken(token);
        String newToken = Jwts
            .builder()
            .setSubject(claims.getSubject())
            .claim("authorities", claims.get("authorities"))
            .setIssuedAt(new Date(System.currentTimeMillis()))
            .setExpiration(new Date(System.currentTimeMillis() + (60000 * 60)))
            .signWith(SignatureAlgorithm.HS256, getSecretKey().getBytes()).compact();
                    
        return "Bearer " + newToken; 

    }

}
