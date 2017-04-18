package entities;

import java.io.Serializable;

import javax.persistence.Entity;

/**
 * Entity implementation class for Entity: Student
 *
 */
@Entity

public class Student extends User implements Serializable {

	private String promotion;
	private static final long serialVersionUID = 1L;

	public Student() {
		super();
	}

	public Student(String name, String login, String password, String promotion) {
		super(name, login, password);
		this.promotion = promotion;
	}

	public String getPromotion() {
		return this.promotion;
	}

	public void setPromotion(String promotion) {
		this.promotion = promotion;
	}

}
