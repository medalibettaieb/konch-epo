package services;

import java.util.List;

import javax.ejb.Remote;

import entities.Project;
import entities.Task;
import entities.TaskStatus;

@Remote
public interface ProjectManagementRemote {
	void addProject(Project project);

	void assignProjectToTask(Task task, Integer idProject);

	List<Project> findAllProjects();

	Project findProjectById(int idProject);

	void assingTutorToProject(Integer idProject, Integer idTutor);

	void assignTasksToProject(List<Task> tasks, Integer idProject);

	void assignTaskToStudent(Task task, Integer i);

	List<Task> findAllTasksByProjectId(Integer idProject);

	List<Task> findAllTasksByProjectIdRequest(Integer idProject);

	void changeTaskStatus(TaskStatus taskStatus, Integer idTask);

	List<Task> findTasksByStudent(Integer id);

	List<Task> findAllTasksByStatusAndProject(Integer idProject, TaskStatus taskStatus);

	List<Task> findAllTasksByStatusAndStudent(Integer idStudent, TaskStatus taskStatus);
}
