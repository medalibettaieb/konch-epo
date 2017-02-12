package services;

import javax.ejb.Local;

@Local
public interface DicoServicesLocal {
	String translate(String anglishWord);
}
