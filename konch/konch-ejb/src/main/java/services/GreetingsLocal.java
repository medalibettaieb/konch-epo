package services;

import javax.ejb.Local;

@Local
public interface GreetingsLocal {
	String sellem(String esm);
}
