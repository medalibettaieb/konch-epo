package services;

import javax.ejb.Local;

@Local
public interface CalculetteServicesLocal {
	Integer add(Integer a, Integer b);
}
