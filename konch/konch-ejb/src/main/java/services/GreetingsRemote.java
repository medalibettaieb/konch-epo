package services;

import javax.ejb.Remote;

@Remote
public interface GreetingsRemote {
	String sellem(String esm);
}
