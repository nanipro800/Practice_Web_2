package nhan.ntu.edu.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import nhan.ntu.edu.model.Contact;
import nhan.ntu.edu.service.ContactService;

@Controller
public class ContactController {
	
	@Autowired
	private ContactService contactService;
	
	@GetMapping("/")
	public String viewHomePage(Model model) {
		model.addAttribute("listContacts", contactService.getAllContact());
		return "index";
	}
	
	@GetMapping("/showNewContactForm")
	public String showNewContactForm(Model model) {
		Contact contact = new Contact();
	    model.addAttribute("contact", contact);
	    return "new_contact";
	 }
	
	@PostMapping("/saveContact")
	public String saveContact(@ModelAttribute("contact") Contact contact) {
		contactService.saveContact(contact);
		return "redirect:/";
	 }
	
	@GetMapping("/showFormForUpdate/{id}")
	public String showFormForUpdate(@PathVariable ( value = "id") long id, Model model) {
		Contact contact = contactService.getContactById(id);
		model.addAttribute("contact", contact);
		return "update_contact";
	}
	
	@GetMapping("/deleteContact/{id}")
	public String deleteContact(@PathVariable (value = "id") long id) {
		this.contactService.deleteContactById(id);
		return "redirect:/";
	}
	
	@RequestMapping(path = {"/","/search"})
	public String home(Contact contact, Model model, String keyword) {
		if(keyword!=null) {
			model.addAttribute("listContacts", contactService.getByKeyword(keyword));
		}
		else
		{
			model.addAttribute("listContacts", contactService.getAllContact());}
		return "index";
	 }
}
