package nhan.ntu.edu.service;

import java.util.List;

import nhan.ntu.edu.model.Contact;

public interface ContactService {
	List<Contact> getAllContact();
	void saveContact(Contact contact);
	Contact getContactById(long id);
	void deleteContactById(long id);
	List<Contact> getByKeyword(String keyword);

}
