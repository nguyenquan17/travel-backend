package com.example.travel.services.impl;

import java.util.Collections;
import java.util.Date;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Service;

import com.example.travel.dto.LoginDTO;
import com.example.travel.entity.User;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.ObjectWriter;

import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
@Service
public class JWTTokenService {
	private static final long EXPIRATION_TIME = 864000000;
	private static final String SECRET = "2362001";
	private static final String PREFIX_TOKEN = "Bearer";
	private static final String AUTHORIZATION  = "Authorization";
	
	public static void addJWTTokenAndUserInfoToBody(HttpServletResponse response, User user) throws Exception {
		// TODO Auto-generated method stub
		String JWT = Jwts.builder()
				.setSubject(user.getUserName())
				.setExpiration(new Date(System.currentTimeMillis() + EXPIRATION_TIME))
				.signWith(SignatureAlgorithm.HS512, SECRET)
				.compact();
		
		// conver user entity to dto
		LoginDTO loginDTO = new LoginDTO(
				user.getActive().equals(true) ? JWT : null,
				user.getUserName(),
				user.getEmail(), 
				user.getFullName(),
				user.getAddress(),
				user.getPhone(),
				user.getRole(),
				user.getActive());
		
		// conver obj sang json
		ObjectWriter objectWriter= new ObjectMapper().writer().withDefaultPrettyPrinter();
		String json = objectWriter.writeValueAsString(loginDTO);
		
		// return json
		response.setContentType("application/json;charset=UTF-8");
		response.getWriter().write(json);
	}

	public static Authentication parseTokenToUserInformation(HttpServletRequest request) {
		// TODO Auto-generated method stub
		String token = request.getHeader(AUTHORIZATION);
		
		if(token == null) {
			return null;
		}
		// parse the token
		String username = Jwts.parser()
				.setSigningKey(SECRET)
				.parseClaimsJws(token.replace(PREFIX_TOKEN, ""))
				.getBody()
				.getSubject();
		if(username != null) {
			return  new UsernamePasswordAuthenticationToken(username, null, Collections.emptyList());
		}else {
			return null;
		}
	}





}
