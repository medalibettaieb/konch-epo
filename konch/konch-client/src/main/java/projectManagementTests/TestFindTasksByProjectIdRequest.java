package projectManagementTests;

import java.util.List;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;

import entities.Task;
import services.ProjectManagementRemote;

public class TestFindTasksByProjectIdRequest {

	public static void main(String[] args) throws NamingException {
		Context context = new InitialContext();
		ProjectManagementRemote projectManagementRemote = (ProjectManagementRemote) context
				.lookup("konch-ear/konch-ejb/ProjectManagement!services.ProjectManagementRemote");

		List<Task> tasks = projectManagementRemote.findAllTasksByProjectIdRequest(1);

		for (Task t : tasks) {
			System.out.println(t.getDescription());
		}
	}

}
