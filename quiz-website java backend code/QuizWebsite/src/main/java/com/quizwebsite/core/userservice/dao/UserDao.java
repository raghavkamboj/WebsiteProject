package com.quizwebsite.core.userservice.dao;

import com.quizwebsite.core.usermodel.User;

public interface UserDao {
	   public boolean addUser(User user);
	   public String getPassword(User user);
	   
	}
