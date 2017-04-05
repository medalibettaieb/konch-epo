package userManagementTests;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;

import entities.Student;
import entities.Teacher;
import services.UserManagementRemote;

public class TestAddUser {

	public static void main(String[] args) throws NamingException {
		Context context = new InitialContext();
		UserManagementRemote userManagementRemote = (UserManagementRemote) context
				.lookup("konch-ear/konch-ejb/UserManagement!services.UserManagementRemote");

		Student student = new Student();
		student.setName("salah");

		Teacher teacher = new Teacher();
		teacher.setName("mourad");

		userManagementRemote.addUser(student);
		userManagementRemote.addUser(teacher);
	}

}
