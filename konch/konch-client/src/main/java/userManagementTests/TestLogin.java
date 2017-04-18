package userManagementTests;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;

import entities.Teacher;
import entities.User;
import services.UserManagementRemote;

public class TestLogin {

	public static void main(String[] args) throws NamingException {
		Context context = new InitialContext();
		UserManagementRemote userManagementRemote = (UserManagementRemote) context
				.lookup("konch-ear/konch-ejb/UserManagement!services.UserManagementRemote");

		User user = userManagementRemote.login("omda", "omda");
		if (user instanceof Teacher) {
			System.out.println("i am a teacher my name is  :" + user.getName());
		} else {
			System.out.println("i am a student my name is  :" + user.getName());
		}

	}

}
