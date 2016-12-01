package org.bridgelabz.iplwebapp.services;

import org.bridgelabz.iplwebapp.model.User;
import org.bridgelabz.iplwebapp.services.UserService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service("userService")
public class UserServiceImpl implements UserService {

	@Autowired
	private UserRepository userRepository;

	@Transactional
	public User save(User user) {
		return userRepository.save(user);
	}

	public boolean findByLogin(String userName, String password) {
		User user = userRepository.findByUserName(userName);

		if (user != null && user.getPassword().equals(password)) {
			return true;
		}

		return false;
	}

	public boolean findByUserName(String userName) {
		User user = userRepository.findByUserName(userName);

		if (user != null) {
			return true;
		}

		return false;
	}

}

/*
 * package org.bridgelabz.iplwebapp.services;
 * 
 * import org.bridgelabz.iplwebapp.model.User; import
 * org.bridgelabz.iplwebapp.services.UserService;
 * 
 * import org.springframework.beans.factory.annotation.Autowired;
 * 
 * public class UserServiceImpl implements UserService {
 * 
 * @Autowired
 * 
 * 
 * public void saveUser(User user) { userDao.addUser(user); }
 * 
 * public User authUser(String email, String password) { return
 * userDao.authUser(email, password); }
 * 
 * public void save(User user) { // TODO Auto-generated method stub
 * 
 * }
 * 
 * public boolean findByLogin(String userName, String password) { // TODO
 * Auto-generated method stub return false; }
 * 
 * public boolean findByUserName(String userName) { // TODO Auto-generated
 * method stub return false; } }
 */