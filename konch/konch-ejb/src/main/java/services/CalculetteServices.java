package services;

import javax.annotation.PostConstruct;
import javax.ejb.Stateless;

/**
 * Session Bean implementation class CalculetteServices
 */
@Stateless
public class CalculetteServices implements CalculetteServicesRemote, CalculetteServicesLocal {

	/**
	 * Default constructor.
	 */
	public CalculetteServices() {
	}

	@PostConstruct
	public void init() {
		System.out.println("ahla from stateless " + this.hashCode());
	}

	@Override
	public Integer add(Integer a, Integer b) {
		return a + b;
	}

}
