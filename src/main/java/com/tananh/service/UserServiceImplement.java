package com.tananh.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.tananh.config.JwtProvider;
import com.tananh.exception.UserException;

import com.tananh.model.User;
import com.tananh.responsitory.UserResponsitory;

@Service
public class UserServiceImplement implements UserService {

	@Autowired
	private UserResponsitory userResponsitory;
	
	@Autowired
	private JwtProvider jwtProvider;
	
	@Override
	public User findUserById(Long id) throws UserException {
		Optional<User> user= userResponsitory.findById(id);
		if(user.isPresent())
		{
			return user.get();
		} throw new UserException("Không tìm  thấy người dùng với id:"+id);
	}

	@Override
	public User findUserByJWT(String jwt)throws UserException  {
		String email=jwtProvider.getEmailFromToken(jwt);
		User user = userResponsitory.findByEmail(email);
		if(user!=null)
		{
			return user;
		}throw new UserException("Không tìm thấy người dùng với jwt- "+jwt);
		
	}

}
