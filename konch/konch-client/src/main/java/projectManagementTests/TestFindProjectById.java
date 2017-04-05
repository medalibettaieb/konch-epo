package projectManagementTests;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;

import entities.Project;
import services.ProjectManagementRemote;

public class TestFindProjectById {

	public static void main(String[] args) throws NamingException {
		Context context = new InitialContext();
		ProjectManagementRemote projectManagementRemote = (ProjectManagementRemote) context
				.lookup("konch-ear/konch-ejb/ProjectManagement!services.ProjectManagementRemote");

		Project project = projectManagementRemote.findProjectById(1);
		
		System.out.println(project.getTasks().size());
	}

}
