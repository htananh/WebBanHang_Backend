package com.tananh.responsitory;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.tananh.model.User;
import java.util.List;


@Repository
public interface  UserResponsitory extends JpaRepository<User, Long>{

	 public User findByEmail(String email) ;
	 
}
