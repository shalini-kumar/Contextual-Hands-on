package com.sapient.oms.entity;
public class Contact {
    
    private String email;
    private String Contact; 
    
    public Contact(String email, String Contact) {
        this.email = email;
        this.Contact = Contact;
       
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getContact() {
        return Contact;
    }

    public void setContact(String Contact) {
        this.Contact = Contact;
    }

    
    @Override
    public String toString() {
        return "[ Email:- "+this.email+", PhoneNumber:- "+this.Contact+" ]";
    }

}
