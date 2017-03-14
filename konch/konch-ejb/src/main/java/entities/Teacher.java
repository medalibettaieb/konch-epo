package entities;

import entities.User;
import java.io.Serializable;
import java.lang.Float;
import javax.persistence.*;

/**
 * Entity implementation class for Entity: Teacher
 *
 */
@Entity

public class Teacher extends User implements Serializable {

	
	private Float salary;
	private static final long serialVersionUID = 1L;

	public Teacher() {
		super();
	}   
	public Float getSalary() {
		return this.salary;
	}

	public void setSalary(Float salary) {
		this.salary = salary;
	}
   
}
