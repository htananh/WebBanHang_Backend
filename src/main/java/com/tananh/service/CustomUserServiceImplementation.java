package com.tananh.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.tananh.model.User;
import com.tananh.responsitory.UserResponsitory;

@Service
public class CustomUserServiceImplementation implements UserDetailsService {

	@Autowired UserResponsitory userReponsitory;
	
	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		User user = userReponsitory.findByEmail(username);
		if(user==null) {
			throw new UsernameNotFoundException("Tài khoản đăng nhập không đúng -"+ username);
		}
		List<GrantedAuthority> authorities = new ArrayList<>();
		
		return new org.springframework.security.core.userdetails.User(user.getEmail(),user.getPassword(),authorities);
	}

}
