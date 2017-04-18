package services;

import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.ejb.LocalBean;
import javax.ejb.Singleton;
import javax.ejb.Startup;

import entities.Project;
import entities.Student;
import entities.Teacher;

/**
 * Session Bean implementation class Util
 */
@Singleton
@LocalBean
@Startup
public class Util {
	@EJB
	private UserManagementLocal userManagementLocal;
	@EJB
	private ProjectManagementRemote projectManagementRemote;

	/**
	 * Default constructor.
	 */
	public Util() {
	}

	@PostConstruct
	public void initDb() {
		Student student = new Student("ghassen", "ghaston", "ghaston", "the last one");
		Student student2 = new Student("mounir", "mounir", "mounir", "the last one");
		Student student3 = new Student("chams", "chams", "chams", "the best one");

		Teacher teacher = new Teacher("imed", "omda", "omda", 120000F);
		Teacher teacher2 = new Teacher("med", "daly", "daly", 1F);

		Project project = new Project("SMART-CITY");
		Project project2 = new Project("SMART-Q");
		Project project3 = new Project("SMART-SOME");

		userManagementLocal.addUser(student);
		userManagementLocal.addUser(student2);
		userManagementLocal.addUser(student3);
		userManagementLocal.addUser(teacher);
		userManagementLocal.addUser(teacher2);

		projectManagementRemote.addProject(project);
		projectManagementRemote.addProject(project2);
		projectManagementRemote.addProject(project3);
	}
}
