package com.tananh.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.tananh.config.JwtProvider;
import com.tananh.exception.UserException;
import com.tananh.model.User;

import com.tananh.service.UserServiceImplement;


@RestController
@RequestMapping("/api/users")
public class UserController {
	
	@Autowired JwtProvider jwtProvider;
	
	@Autowired UserServiceImplement serServiceImplement;
	@GetMapping("/profile")
    public ResponseEntity<User> getUserProfile(@RequestHeader("Authorization") String jwt)
    throws UserException {
            User user = serServiceImplement.findUserByJWT(jwt);
            return new ResponseEntity<User>(user,HttpStatus.ACCEPTED);
            
        }
    }

