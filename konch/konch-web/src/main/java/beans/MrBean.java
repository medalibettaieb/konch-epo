package beans;

import javax.faces.bean.ApplicationScoped;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;

@ManagedBean
@ApplicationScoped
public class MrBean {
	@ManagedProperty(value = "#{projectBean}")
	private ProjectBean projectBean;
	private String name = "";
	private String result = "";

	public void displayProject() {

		System.out.println(projectBean.getProject().getName());
	}

	public void doSallem() {
		result = name;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getResult() {
		return result;
	}

	public void setResult(String result) {
		this.result = result;
	}

	public ProjectBean getProjectBean() {
		return projectBean;
	}

	public void setProjectBean(ProjectBean projectBean) {
		this.projectBean = projectBean;
	}

}
