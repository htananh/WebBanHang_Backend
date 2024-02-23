package com.tananh.config;

import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Service;
import java.util.*;

import javax.crypto.SecretKey;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jws;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.security.Keys;

@Service
public class JwtProvider {
	
	private final long JWT_EXPIRATION = 604800000L;
	SecretKey key = Keys.hmacShaKeyFor(JwtConstant.SECRET_KEY.getBytes());

	public String generateToken(Authentication authentication)
	{
		Date now = new Date();
		Date expiryDate = new Date(now.getTime() + JWT_EXPIRATION);
		String token = Jwts.builder()
				.setIssuedAt(now)
				.setExpiration(expiryDate)
				.claim("email",authentication.getName())
				.signWith(key)
				.compact();
				
		return token;
	}
//	public String getEmailFromToken(String jwt)
//	{
//		jwt = jwt.substring(7); 
//		Claims claims = Jwts.parserBuilder().setSigningKey(key).build().parseClaimsJwt(jwt).getBody();
//		String email = String.valueOf(claims.get("email"));
//        return email;
//	}
	public String getEmailFromToken(String jwt) {
	    jwt = jwt.substring(7); // Gán kết quả của substring(7) vào biến jwt
	    Jws<Claims> claimsJws = Jwts.parserBuilder().setSigningKey(key).build().parseClaimsJws(jwt);
	    Claims claims = claimsJws.getBody();
	    String email = String.valueOf(claims.get("email"));
	    return email;
	}

}
