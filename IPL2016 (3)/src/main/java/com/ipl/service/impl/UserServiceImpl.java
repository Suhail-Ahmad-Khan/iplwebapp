package com.ipl.service.impl;

import org.springframework.beans.factory.annotation.Autowired;

import com.ipl.dao.UserDao;
import com.ipl.model.User;
import com.ipl.service.UserService;

public class UserServiceImpl implements UserService  {
	
	@Autowired
    private UserDao userDao;
	
    public void addUser(User user) {
    	userDao.addUser(user);
	}
    
    public User authUser( String email, String password ){
    	return userDao.authUser(email, password);
    }
}
