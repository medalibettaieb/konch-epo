package services;

import javax.ejb.Stateless;

@Stateless
public class Greetings implements GreetingsLocal, GreetingsRemote {

	@Override
	public String sellem(String esm) {
		return "ahla w sahla ya " + esm;
	}

}
