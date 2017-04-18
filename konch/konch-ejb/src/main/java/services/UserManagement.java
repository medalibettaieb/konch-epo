package services;

import java.util.List;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import entities.User;

/**
 * Session Bean implementation class UserManagement
 */
@Stateless
public class UserManagement implements UserManagementRemote, UserManagementLocal {
	@PersistenceContext
	private EntityManager entityManager;

	/**
	 * Default constructor.
	 */
	public UserManagement() {
	}

	@Override
	public void addUser(User user) {
		entityManager.persist(user);
	}

	@Override
	public void deleteUserById(Integer id) {
		entityManager.remove(findUserById(id));
	}

	@Override
	public void deleteUser(User user) {
		entityManager.remove(entityManager.merge(user));
	}

	@Override
	public void updateUser(User user) {
		entityManager.merge(user);
	}

	@Override
	public User findUserById(Integer id) {
		return entityManager.find(User.class, id);
	}

	@Override
	public List<User> findAllUsers() {
		return entityManager.createQuery("select u from User u ", User.class).getResultList();
	}

	@Override
	public User login(String login, String password) {
		User user = null;
		try {
			user = entityManager.createQuery("select u from User u where u.login=:l and u.password=:p", User.class)
					.setParameter("l", login).setParameter("p", password).getSingleResult();
		} catch (Exception e) {
			System.err.println("user not found");
		}
		return user;
	}

}
