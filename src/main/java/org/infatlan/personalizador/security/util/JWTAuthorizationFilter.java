package org.infatlan.personalizador.security.util;

import java.io.IOException;
import java.util.List;
import java.util.stream.Collectors;
import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.filter.OncePerRequestFilter;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;

import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.Claims;
import io.jsonwebtoken.ExpiredJwtException;
import io.jsonwebtoken.MalformedJwtException;
import io.jsonwebtoken.UnsupportedJwtException;


public class JWTAuthorizationFilter extends OncePerRequestFilter {

	private final String HEADER = "Authorization";
	private final String PREFIX = "Bearer ";

    @Override
	protected void doFilterInternal(HttpServletRequest req, HttpServletResponse res, FilterChain chain) throws ServletException, IOException{
		try {
			if (existeJWTToken(req, res)) {
                Claims claims = validateToken(req);
				if (claims.get("authorities") != null) {
					setUpSpringAuthentication(claims);
				} else {
					SecurityContextHolder.clearContext();
				}
			} else {
					SecurityContextHolder.clearContext();
			}
            chain.doFilter(req, res);
        } catch (ExpiredJwtException | UnsupportedJwtException | MalformedJwtException e) {
            res.setStatus(HttpServletResponse.SC_FORBIDDEN);
            ((HttpServletResponse) res).sendError(HttpServletResponse.SC_FORBIDDEN, e.getMessage());
        }
	}

    private boolean existeJWTToken(HttpServletRequest request, HttpServletResponse res) {
		
        String authenticationHeader = request.getHeader(HEADER);
		if (authenticationHeader == null || !authenticationHeader.startsWith(PREFIX))
			return false;
		return true;
	
    }

    private Claims validateToken(HttpServletRequest request) {

        String jwtToken = request.getHeader(HEADER).replace(PREFIX, "");
		return Jwts.parser().setSigningKey(JWTUtils.getSecretKey().getBytes()).parseClaimsJws(jwtToken).getBody();
    
    }

    @SuppressWarnings("unchecked")
    private void setUpSpringAuthentication(Claims claims){

        List<String> authorities = (List<String>) claims.get("authorities");
		UsernamePasswordAuthenticationToken auth = new UsernamePasswordAuthenticationToken(claims.getSubject(), null,
				authorities.stream().map(SimpleGrantedAuthority::new).collect(Collectors.toList()));
		
        SecurityContextHolder.getContext().setAuthentication(auth);

    }

}