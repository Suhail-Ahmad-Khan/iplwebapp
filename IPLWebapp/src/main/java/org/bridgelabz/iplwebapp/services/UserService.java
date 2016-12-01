package org.bridgelabz.iplwebapp.services;

import org.bridgelabz.iplwebapp.model.User;

public interface UserService {

	public void save(User user);

	boolean findByLogin(String userName, String password);

	boolean findByUserName(String userName);

}
