package userManagementTests;

import java.util.List;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;

import entities.User;
import services.UserManagementRemote;

public class TestFindAllUsers {

	public static void main(String[] args) throws NamingException {
		Context context = new InitialContext();
		UserManagementRemote userManagementRemote = (UserManagementRemote) context
				.lookup("konch-ear/konch-ejb/UserManagement!services.UserManagementRemote");

		List<User> users = userManagementRemote.findAllUsers();

		for (User u : users) {
			System.out.println(u.getName());
		}
	}

}
