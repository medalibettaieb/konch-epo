package beans;

import java.util.ArrayList;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;

import entities.Project;
import services.ProjectManagementLocal;

@ManagedBean
@SessionScoped
public class ProjectBean {
	@EJB
	private ProjectManagementLocal projectManagementLocal;
	private List<Project> projects;
	private Project project;
	private Boolean showForm = false;

	@PostConstruct
	public void init() {
		projects = new ArrayList<>();
		setProject(new Project());
	}

	public void doShowFormNew() {
		project = new Project();
		showForm = true;
	}

	public void doShowForm() {
		showForm = true;
	}

	public void dosaveOrUpdate() {
		projectManagementLocal.addProject(project);
		showForm = false;
	}

	public void doDelete() {
		projectManagementLocal.deleteProject(project);
		showForm = false;
	}

	public void cancel() {
		showForm = false;
		project = new Project();
	}

	public List<Project> getProjects() {
		projects = projectManagementLocal.findAllProjects();
		return projects;
	}

	public void setProjects(List<Project> projects) {
		this.projects = projects;
	}

	public Project getProject() {
		return project;
	}

	public void setProject(Project project) {
		this.project = project;
	}

	public Boolean getShowForm() {
		return showForm;
	}

	public void setShowForm(Boolean showForm) {
		this.showForm = showForm;
	}

}
