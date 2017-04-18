package services;

import java.util.List;

import javax.ejb.Remote;

import entities.User;

@Remote
public interface UserManagementRemote {
	void addUser(User user);

	void deleteUserById(Integer id);

	void deleteUser(User user);

	void updateUser(User user);

	User findUserById(Integer id);

	List<User> findAllUsers();
	
	User login(String login,String password);
}
