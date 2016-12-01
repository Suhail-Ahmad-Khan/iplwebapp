package com.ipl.service;

import com.ipl.model.User;

public interface UserService {
	public void addUser(User user);
	public User authUser(String email,String password);
}
