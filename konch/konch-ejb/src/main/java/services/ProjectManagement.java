package services;

import java.util.Calendar;
import java.util.Date;
import java.util.List;

import javax.ejb.EJB;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import entities.Project;
import entities.Task;
import entities.TaskStatus;
import entities.User;

/**
 * Session Bean implementation class ProjectManagement
 */
@Stateless
public class ProjectManagement implements ProjectManagementRemote, ProjectManagementLocal {
	@PersistenceContext
	private EntityManager entityManager;

	@EJB
	private UserManagementLocal userManagementLocal;

	/**
	 * Default constructor.
	 */
	public ProjectManagement() {
	}

	@Override
	public void addProject(Project project) {
		entityManager.persist(project);
	}

	@Override
	public void assignProjectToTask(Task task, Integer idProject) {
		Project projectFound = findProjectById(idProject);

		task.setProject(projectFound);

		entityManager.merge(task);

	}

	@Override
	public List<Project> findAllProjects() {
		return entityManager.createQuery("select z from Project z", Project.class).getResultList();
	}

	@Override
	public Project findProjectById(int idProject) {
		return entityManager.find(Project.class, idProject);
	}

	@Override
	public void assingTutorToProject(Integer idProject, Integer idTutor) {
		Project project = findProjectById(idProject);

		User user = userManagementLocal.findUserById(idTutor);

		project.setSupervisor(user);

		entityManager.merge(project);

	}

	@Override
	public void assignTasksToProject(List<Task> tasks, Integer idProject) {
		Project projectFound = findProjectById(idProject);

		projectFound.linkTasksToThisProject(tasks);

		entityManager.merge(projectFound);

	}

	@Override
	public void assignTaskToStudent(Task task, Integer i) {
		User user = userManagementLocal.findUserById(i);

		task.setAssignee(user);
		task.setTaskStatus(TaskStatus.INPROGRESS);

		entityManager.merge(task);

	}

	@Override
	public List<Task> findAllTasksByProjectId(Integer idProject) {
		Project project = findProjectById(idProject);

		System.out.println(project.getTasks().size());

		List<Task> tasks = project.getTasks();

		return tasks;
	}

	@Override
	public List<Task> findAllTasksByProjectIdRequest(Integer idProject) {
		return entityManager.createQuery("SELECT t FROM Task t WHERE t.project.id =:param1", Task.class)
				.setParameter("param1", idProject).getResultList();
	}

	@Override
	public void changeTaskStatus(TaskStatus taskStatus, Integer idTask) {
		Task task = entityManager.find(Task.class, idTask);
		task.setTaskStatus(taskStatus);

		entityManager.merge(task);

	}

	@Override
	public List<Task> findTasksByStudent(Integer id) {
		return entityManager.createQuery("SELECT t FROM Task t WHERE t.assignee.id=:param", Task.class)
				.setParameter("param", id).getResultList();
	}

	@Override
	public List<Task> findAllTasksByStatusAndProject(Integer idProject, TaskStatus taskStatus) {
		return entityManager
				.createQuery("SELECT t FROM Task t WHERE t.project.id=:param1 AND t.taskStatus=:param2", Task.class)
				.setParameter("param1", idProject).setParameter("param2", taskStatus).getResultList();
	}

	@Override
	public List<Task> findAllTasksByStatusAndStudent(Integer idStudent, TaskStatus taskStatus) {
		return entityManager
				.createQuery("SELECT t FROM Task t WHERE t.assignee.id=:param1 AND t.taskStatus=:param2", Task.class)
				.setParameter("param1", idStudent).setParameter("param2", taskStatus).getResultList();
	}

	@Override
	public Integer projectDuration(Integer idProject) {
		List<Task> tasks = findAllTasksByProjectId(idProject);

		Integer totalEstimation = 0;
		for (Task task : tasks) {
			totalEstimation += task.getEstimation();
		}
		return totalEstimation;

	}

	@Override
	public Date deadlineProject(Integer idProject, Date date) {
		Integer projectDuration = projectDuration(idProject);

		Calendar calendar = Calendar.getInstance();
		calendar.setTime(date);
		calendar.add(Calendar.DATE, projectDuration);
		return calendar.getTime();

	}
}
