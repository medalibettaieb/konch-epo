package services;

import java.util.List;

import javax.ejb.Local;

import entities.User;

@Local
public interface UserManagementLocal {
	void addUser(User user);

	void deleteUserById(Integer id);

	void deleteUser(User user);

	void updateUser(User user);

	User findUserById(Integer id);

	List<User> findAllUsers();
}
