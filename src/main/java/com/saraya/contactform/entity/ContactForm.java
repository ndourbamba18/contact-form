package com.saraya.contactform.entity;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

/**
 * @author NdourCodeur
 **/
public class ContactForm {

    @NotBlank(message = "Name field is required!")
    @Size(min = 2, max = 100)
    private String name;

    @NotBlank(message = "Email field is required!")
    @Size(max = 180)
    @Email(message = "Please, enter a valid email.")
    private String email;

    @NotBlank(message = "Phone field is required!")
    @Size(max = 20)
    private String phone;

    @Size(max = 150)
    private String subject;

    @NotBlank(message = "Message field is required!")
    @Size(max = 300)
    private String message;

    public ContactForm() { }

    public ContactForm(String name, String email, String phone, String subject, String message) {
        this.name = name;
        this.email = email;
        this.phone = phone;
        this.subject = subject;
        this.message = message;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getSubject() {
        return subject;
    }

    public void setSubject(String subject) {
        this.subject = subject;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }
}
