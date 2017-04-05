package projectManagementTests;

import java.util.ArrayList;
import java.util.List;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;

import entities.Task;
import services.ProjectManagementRemote;

public class TestAssignTasksToProject {

	public static void main(String[] args) throws NamingException {
		Context context = new InitialContext();
		ProjectManagementRemote projectManagementRemote = (ProjectManagementRemote) context
				.lookup("konch-ear/konch-ejb/ProjectManagement!services.ProjectManagementRemote");

		Task task = new Task("task 1");
		Task task2 = new Task("task 2");
		Task task3 = new Task("task 3");

		List<Task> tasks = new ArrayList<>();
		tasks.add(task);
		tasks.add(task2);
		tasks.add(task3);

		projectManagementRemote.assignTasksToProject(tasks, 1);
	}

}
