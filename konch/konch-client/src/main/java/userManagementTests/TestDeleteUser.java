package userManagementTests;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;

import entities.Student;
import services.UserManagementRemote;

public class TestDeleteUser {

	public static void main(String[] args) throws NamingException {
		Context context = new InitialContext();
		UserManagementRemote userManagementRemote = (UserManagementRemote) context
				.lookup("konch-ear/konch-ejb/UserManagement!services.UserManagementRemote");

		Student student = (Student) userManagementRemote.findUserById(1);

		System.out.println(student.getName());
		
		userManagementRemote.deleteUser(student);
	}

}
