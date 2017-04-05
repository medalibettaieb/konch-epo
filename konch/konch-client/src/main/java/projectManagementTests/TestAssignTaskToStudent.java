package projectManagementTests;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;

import entities.Task;
import services.ProjectManagementRemote;

public class TestAssignTaskToStudent {

	public static void main(String[] args) throws NamingException {
		Context context = new InitialContext();
		ProjectManagementRemote projectManagementRemote = (ProjectManagementRemote) context
				.lookup("konch-ear/konch-ejb/ProjectManagement!services.ProjectManagementRemote");

		Task task = new Task("fadda");
		
		projectManagementRemote.assignTaskToStudent(task,1);
	}

}
