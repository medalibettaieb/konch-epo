package services;

import java.util.HashMap;
import java.util.Map;

import javax.ejb.Singleton;

/**
 * Session Bean implementation class DicoServices
 */
@Singleton
public class DicoServices implements DicoServicesRemote, DicoServicesLocal {
	private Map<String, String> mapOfWords;

	/**
	 * Default constructor.
	 */
	public DicoServices() {
		System.out.println("ahla from the singleton" + this.hashCode());
		mapOfWords = new HashMap<>();
		mapOfWords.put("add", "ajouter");
		mapOfWords.put("map", "carte");
		mapOfWords.put("discount", "solde");
	}

	@Override
	public String translate(String anglishWord) {
		return mapOfWords.get(anglishWord);
	}

}
