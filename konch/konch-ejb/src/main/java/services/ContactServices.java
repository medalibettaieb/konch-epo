package services;

import java.util.ArrayList;
import java.util.List;

import javax.ejb.Stateful;

/**
 * Session Bean implementation class ContactServices
 */
@Stateful
public class ContactServices implements ContactServicesRemote, ContactServicesLocal {
	private List<String> contacts = new ArrayList<>();

	/**
	 * Default constructor.
	 */
	public ContactServices() {
		System.out.println("ahla from stateful "+this.hashCode());
	}

	@Override
	public void addContact(String contactName) {
		contacts.add(contactName);
	}

	@Override
	public List<String> findAllContacts() {
		return contacts;
	}

}
