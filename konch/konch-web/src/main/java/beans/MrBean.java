package beans;

import javax.faces.bean.ManagedBean;

@ManagedBean
public class MrBean {
	private String name = "";
	private String result = "";

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

}
