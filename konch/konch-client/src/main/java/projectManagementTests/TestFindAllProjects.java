package projectManagementTests;

import java.util.List;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;

import entities.Project;
import services.ProjectManagementRemote;

public class TestFindAllProjects {

	public static void main(String[] args) throws NamingException {
		Context context = new InitialContext();
		ProjectManagementRemote projectManagementRemote = (ProjectManagementRemote) context
				.lookup("konch-ear/konch-ejb/ProjectManagement!services.ProjectManagementRemote");

		List<Project> projects = projectManagementRemote.findAllProjects();

		for (Project p : projects) {
			System.out.println(p.getName());
		}

	}

}
