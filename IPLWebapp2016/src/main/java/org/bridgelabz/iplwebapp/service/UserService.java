package org.bridgelabz.iplwebapp.service;

import org.bridgelabz.iplwebapp.model.User;
import org.springframework.stereotype.Repository;

@Repository
public interface UserService {
	
	public void addUser(User user);

	public User authUser(String email, String password);

}
