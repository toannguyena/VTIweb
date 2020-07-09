package com.vti.academy.web.configuration;

import java.nio.charset.Charset;
import java.util.ArrayList;
import java.util.Date;
import java.util.Map;
import java.util.function.Function;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Component;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;

@Component
public class JwtTokenUtil{
	public static final long JWT_TOKEN_VALIDITY = 24 * 60 * 60;
	@Value("${app.jwtSecret}")
	private String secret;
	
	@Value("${app.jwtSecretRefreshToken}")
	private String secretRefreshToken;

	//retrieve username from jwt token
	public String getUsernameFromToken(String token) {
		return getAllClaimsFromToken(token).get("username").toString();
	}

	//retrieve expiration date from jwt token
	public Date getExpirationDateFromToken(String token) {
		return getClaimFromToken(token, Claims::getExpiration);
	}
	
	public <T> T getClaimFromToken(String token, Function<Claims, T> claimsResolver) {
		final Claims claims = getAllClaimsFromToken(token);
		return claimsResolver.apply(claims);
	}

	// for retrieveing any information from token we will need the secret key
	private Claims getAllClaimsFromToken(String token) {
		
		return Jwts.parser().setSigningKey(secret.getBytes(Charset.forName("UTF-8"))).parseClaimsJws(token).getBody();
	}

	//check if the token has expired
	private Boolean isTokenExpired(String token) {
		final Date expiration = getExpirationDateFromToken(token);
		return expiration.before(new Date());
	}

	//generate manual token
	public String generateToken(Map<String, Object> claims, String username) {
		return doGenerateToken(claims, username);
	}
	
	//generate manual refresh token
	public String generateRefreshToken(Map<String, Object> claims, String username) {
		return doGenerateRefreshToken(claims, username);
	}

	private String doGenerateToken(Map<String, Object> claims, String subject) {
		return Jwts.builder().setClaims(claims).setSubject(subject).setIssuedAt(new Date(System.currentTimeMillis()))
				.setExpiration(new Date(System.currentTimeMillis() + JWT_TOKEN_VALIDITY * 1000))
				.signWith(SignatureAlgorithm.HS384, secret.getBytes(Charset.forName("UTF-8"))).compact();
	}
	
	private String doGenerateRefreshToken(Map<String, Object> claims, String subject) {
		return Jwts.builder().setClaims(claims).setSubject(subject).setIssuedAt(new Date(System.currentTimeMillis()))
				.setExpiration(new Date(System.currentTimeMillis() + JWT_TOKEN_VALIDITY * 366 * 1000))
				.signWith(SignatureAlgorithm.HS384, secretRefreshToken.getBytes(Charset.forName("UTF-8"))).compact();
	}

	//validate token
	public Boolean validateToken(String token, UserDetails userDetails) {
		try {
			final String username = getUsernameFromToken(token);
			return (username.equals(userDetails.getUsername()) && !isTokenExpired(token));	
		} catch (Exception e) {
			return false;
		}
		
	}
	
	public  UsernamePasswordAuthenticationToken getAuthentication(HttpServletRequest request) {
        String token = request.getHeader("Authorization");
        if (token != null) {
            // parse the token.

            String cleanToken = token.replace("Bearer ", "");
            Claims claims = Jwts.parser().setSigningKey(secret.getBytes(Charset.forName("UTF-8"))).parseClaimsJws(cleanToken).getBody();

            if (claims != null) {
                return new UsernamePasswordAuthenticationToken(claims, null, new ArrayList<>());
            }
            return null;
        }
        return null;
    }
}
