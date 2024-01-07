package com.tananh.service;

import com.tananh.exception.UserException;
import com.tananh.model.User;

public interface UserService {

	public User findUserById(Long id)throws UserException;
	public User findUserByJWT(String jwt)throws UserException ;
}
