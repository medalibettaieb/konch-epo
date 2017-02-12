package services;

import javax.ejb.Remote;

@Remote
public interface CalculetteServicesRemote {
	Integer add(Integer a, Integer b);

}
