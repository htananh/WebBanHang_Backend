package com.tananh.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.security.core.*;

import com.tananh.config.JwtProvider;
import com.tananh.exception.UserException;
import com.tananh.model.User;
import com.tananh.request.LoginRequest;
import com.tananh.respone.AuthRespone;
import com.tananh.responsitory.UserResponsitory;
import com.tananh.service.CustomUserServiceImplementation;

@RestController
@RequestMapping("/auth")
public class AuthController {

	@Autowired PasswordEncoder passwordEndcoder;
	@Autowired UserResponsitory userResponsitory;
	@Autowired JwtProvider jwtProvider;
	@Autowired CustomUserServiceImplementation customUserServiceImplementation;
	@PostMapping("/signup")
	ResponseEntity<AuthRespone>createUserHanlder(@RequestBody User user) throws UserException {
		String email = user.getEmail();
		String password = user.getPassword();
		String firstName=user.getFirstName();
		String lastName=user.getLastName();
		String mobile=user.getMoblie();
		
		User userCheck = userResponsitory.findByEmail(email);
		
		if(userCheck!=null)
		{
			throw new UserException("Email đã được sử dụng");
		}
		
		User createdUser = new User();
		createdUser.setEmail(email);
		createdUser.setPassword(passwordEndcoder.encode(password));
		createdUser.setFirstName(firstName);
		createdUser.setLastName(lastName);
		createdUser.setMoblie(mobile);
		User savedUser= userResponsitory.save(createdUser);
		
		Authentication authentication = new UsernamePasswordAuthenticationToken(savedUser.getEmail(), savedUser.getPassword());
		SecurityContextHolder.getContext().setAuthentication(authentication);
		
		String token=jwtProvider.generateToken(authentication);
		AuthRespone authRespone = new AuthRespone();
		authRespone.setJwt(token);
		authRespone.setMessage("Đăng kí thành công!");
		
		return new ResponseEntity<>(authRespone, HttpStatus.CREATED);
		
	}
	
	@PostMapping("/signin")
	ResponseEntity<AuthRespone> LoginHanlder(@RequestBody LoginRequest loginRequest) throws UserException{
		String username = loginRequest.getEmail();
		String password=loginRequest.getPassword();
		
		Authentication authentication = authenticate(username,password);
		SecurityContextHolder.getContext().setAuthentication(authentication);
		
		String token=jwtProvider.generateToken(authentication);
		AuthRespone authRespone = new AuthRespone();
		authRespone.setJwt(token);
		authRespone.setMessage("Đăng nhập thành công!");
		
		return new ResponseEntity<>(authRespone, HttpStatus.CREATED);
	
	}

	private Authentication authenticate(String username, String password) {
		UserDetails userDetails = customUserServiceImplementation.loadUserByUsername(username);
		if(userDetails==null)
		{
			throw new BadCredentialsException("Tài khoản không đúng hoặc không chính xác!");
		}
		if(!passwordEndcoder.matches(password, userDetails.getPassword()))
		{
			throw new BadCredentialsException("Mật khẩu không chính xác!");
		}
		return new UsernamePasswordAuthenticationToken(userDetails,null,userDetails.getAuthorities());
	}
}


