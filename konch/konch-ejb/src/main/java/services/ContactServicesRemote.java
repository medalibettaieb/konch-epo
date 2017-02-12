package services;

import java.util.List;

import javax.ejb.Remote;

@Remote
public interface ContactServicesRemote {
	void addContact(String contactName);
	
	List<String> findAllContacts();
}
