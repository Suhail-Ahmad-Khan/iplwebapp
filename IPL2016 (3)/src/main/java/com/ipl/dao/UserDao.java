package com.ipl.dao;

import com.ipl.model.User;

public interface UserDao {
	
	public void addUser(User user) ;
	public User authUser(String email,String password);
}
