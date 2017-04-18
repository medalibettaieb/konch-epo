package beans;

import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;

import entities.Teacher;
import entities.User;
import services.UserManagementLocal;

@ManagedBean
@SessionScoped
public class Identity {
	@EJB
	private UserManagementLocal userManagementLocal;
	private User user;

	public String doLogin() {
		String navigateTo = "";

		User userLoggedIn = userManagementLocal.login(user.getLogin(), user.getPassword());
		if (userLoggedIn != null) {
			user = userLoggedIn;
			if (userLoggedIn instanceof Teacher) {
				navigateTo = "/pages/teacher/home?faces-redirect=true";
			} else {
				navigateTo = "/pages/student/home?faces-redirect=true";
			}
		} else {
			navigateTo = "/horror?faces-redirect=true";
		}
		return navigateTo;
	}

	@PostConstruct
	public void init() {
		user = new User();
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

}
