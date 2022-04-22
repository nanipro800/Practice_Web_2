package nhan.ntu.edu.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import nhan.ntu.edu.model.Contact;
import nhan.ntu.edu.repository.ContactRepository;

@Service
public class ContactServiceImpl implements ContactService {

	@Autowired
	private ContactRepository contactRepository;
	
	@Override
	public List<Contact> getAllContact() {
		return contactRepository.findAll();
	}

	@Override
	public void saveContact(Contact contact) {
		this.contactRepository.save(contact);
		
	}

	@Override
	public Contact getContactById(long id) {
		Optional < Contact > optional = contactRepository.findById(id);
		Contact contact = null;
		if (optional.isPresent()) {
			contact = optional.get();
		}
		else 
		{
			throw new RuntimeException(" Contact not found for id :: " + id);    
		}
		return contact;
	}

	@Override
	public void deleteContactById(long id) {
		this.contactRepository.deleteById(id);
	}

	@Override
	public List<Contact> getByKeyword(String keyword) {
		return contactRepository.findByKeyword(keyword);
	}



}
