package com.saraya.contactform.controller;

import com.saraya.contactform.entity.ContactForm;
import com.saraya.contactform.message.Message;
import com.saraya.contactform.servises.EmailService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;


/**
 * @author NdourCodeur
 **/

@RestController
@RequestMapping("/api/contact")
@CrossOrigin(origins = "*")
public class ContactController {

	private final EmailService emailService;

	public ContactController(EmailService emailService) {
		this.emailService = emailService;
	}


	// URL = http://127.0.0.1:8001/api/contact/sendEmail
	@PostMapping("/sendEmail")
	public ResponseEntity<?> sendEmail(@Valid @RequestBody ContactForm contactForm) {
		
		emailService.send(contactForm);
		
		return new ResponseEntity<>(new Message("Email sent with success (:"), HttpStatus.CREATED);
	}
}
