package entities;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;

/**
 * Entity implementation class for Entity: Task
 *
 */
@Entity

public class Task implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	private String description;
	private String priority;
	private Integer estimation;
	private Date dateOfAssignementToStudent;
	private Date dateOfAccomplishment;

	private TaskStatus taskStatus;

	@OneToMany(mappedBy = "task")
	private List<TaskReport> taskReports;
	@ManyToOne
	private User assignee;

	@ManyToOne
	private Project project;

	public Task() {
		super();
	}

	public Task(String description) {
		super();
		this.description = description;
		this.taskStatus = TaskStatus.NOTASSIGNED;
	}

	public Integer getId() {
		return this.id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getDescription() {
		return this.description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public User getAssignee() {
		return assignee;
	}

	public void setAssignee(User assignee) {
		this.assignee = assignee;
	}

	public Project getProject() {
		return project;
	}

	public void setProject(Project project) {
		this.project = project;
	}

	public TaskStatus getTaskStatus() {
		return taskStatus;
	}

	public void setTaskStatus(TaskStatus taskStatus) {
		this.taskStatus = taskStatus;
	}

	public Date getDateOfAssignementToStudent() {
		return dateOfAssignementToStudent;
	}

	public void setDateOfAssignementToStudent(Date dateOfAssignementToStudent) {
		this.dateOfAssignementToStudent = dateOfAssignementToStudent;
	}

	public Date getDateOfAccomplishment() {
		return dateOfAccomplishment;
	}

	public void setDateOfAccomplishment(Date dateOfAccomplishment) {
		this.dateOfAccomplishment = dateOfAccomplishment;
	}

	public List<TaskReport> getTaskReports() {
		return taskReports;
	}

	public void setTaskReports(List<TaskReport> taskReports) {
		this.taskReports = taskReports;
	}

	public String getPriority() {
		return priority;
	}

	public void setPriority(String priority) {
		this.priority = priority;
	}

	public Integer getEstimation() {
		return estimation;
	}

	public void setEstimation(Integer estimation) {
		this.estimation = estimation;
	}

}
