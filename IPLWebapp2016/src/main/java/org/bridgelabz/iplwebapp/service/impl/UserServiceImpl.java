package org.bridgelabz.iplwebapp.service.impl;

import org.springframework.beans.factory.annotation.Autowired;

import org.bridgelabz.iplwebapp.dao.UserDao;
import org.bridgelabz.iplwebapp.model.User;
import org.bridgelabz.iplwebapp.service.UserService;

public class UserServiceImpl implements UserService {

	@Autowired
	private UserDao userDao;

	public void addUser(User user) {
		userDao.addUser(user);
	}

	public User authUser(String email, String password) {
		return userDao.authUser(email, password);
	}

}
