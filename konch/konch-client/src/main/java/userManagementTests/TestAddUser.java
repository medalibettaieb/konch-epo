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

		Student student = new Student("ghassen", "ghaston", "ghaston", "the last one");
		Student student2 = new Student("mounir", "mounir", "mounir", "the last one");
		Student student3 = new Student("chams", "chams", "chams", "the best one");

		Teacher teacher = new Teacher("imed", "omda", "omda", 120000F);
		Teacher teacher2 = new Teacher("med", "daly", "daly", 1F);

		userManagementRemote.addUser(student);
		userManagementRemote.addUser(student2);
		userManagementRemote.addUser(student3);
		userManagementRemote.addUser(teacher);
		userManagementRemote.addUser(teacher2);
	}
	

}
