package entities;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

/**
 * Entity implementation class for Entity: TaskReport
 *
 */
@Entity

public class TaskReport implements Serializable {

	@Id
	private Integer id;
	private Date dateOfOperation;

	@ManyToOne
	private Task task;
	private static final long serialVersionUID = 1L;

	public TaskReport() {
		super();
	}

	public Integer getId() {
		return this.id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public Date getDateOfOperation() {
		return this.dateOfOperation;
	}

	public void setDateOfOperation(Date dateOfOperation) {
		this.dateOfOperation = dateOfOperation;
	}

	public Task getTask() {
		return task;
	}

	public void setTask(Task task) {
		this.task = task;
	}

}
