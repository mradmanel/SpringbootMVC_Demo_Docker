package com.sip.controllers;

import java.util.List;
import java.util.Optional;

import javax.management.AttributeNotFoundException;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.sip.entities.Article;
import com.sip.entities.Contact;
import com.sip.entities.Provider;
import com.sip.repositories.ContactRepository;
@Controller
@RequestMapping("/contact")
public class ContactController {
	private final ContactRepository contactRepository;
	@Autowired
	public ContactController(ContactRepository contactRepository) {
		this.contactRepository = contactRepository;
	}
	@GetMapping("/list")
	public String listContacts(Model model) {
		List<Contact> lc = (List<Contact>) contactRepository.findAll();
		if (lc.size() == 0)
			lc = null;
		model.addAttribute("contacts", lc);
		return "contact/listContact";
	}
	

	@GetMapping(value = "/add")
	public String showAddContact(Model model) {
	    Contact contact = new Contact();
	    model.addAttribute("add", true);
	    model.addAttribute("contact", contact);
	    return "contact/addContact";
	}
	
	@PostMapping(value = "/add")
	public String addContact(Model model,@Valid Contact contact ,BindingResult result) {        
		 if (result.hasErrors()) {
	            return "contact/addContact";
	        }
	       contactRepository.save(contact);
	        return "redirect:list";
	    }
	
	 
	@GetMapping(value = {"/contact/{contactId}/delete"})
	public String deleteContactById(
	        Model model, @PathVariable long contactId,BindingResult result) {
		if (result.hasErrors()) {
            return "contact/addContact";
		}
	        contactRepository.deleteById(contactId);
	        return "redirect:/listContact";
	    } 
}