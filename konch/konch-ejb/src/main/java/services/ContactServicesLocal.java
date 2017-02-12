package services;

import java.util.List;

import javax.ejb.Local;

@Local
public interface ContactServicesLocal {
	void addContact(String contactName);

	List<String> findAllContacts();
}
