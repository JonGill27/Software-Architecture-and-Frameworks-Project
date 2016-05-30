/*
    Jon Gillingsrud, s198618
    Christoffer Fredriksen, s198583
*/

package com.s198618s198583.java.models;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "Contact")
public class Contact {

    @Id
    @Column(name = "ID")
    private int ID;

    @Column(name = "Name")
    private String Name;

    @Column(name = "Email")
    private String Email;

    @Column(name = "Message")
    private String Message;

    public Contact() {
    }

    public Contact(String name, String email, String message) {

        Name = name;
        Email = email;
        Message = message;
    }

    public int getID() {
        return ID;
    }

    public String getName() {
        return Name;
    }

    public void setName(String name) {
        Name = name;
    }

    public String getEmail() {
        return Email;
    }

    public void setEmail(String email) {
        Email = email;
    }

    public String getMessage() {
        return Message;
    }

    public void setMessage(String message) {
        Message = message;
    }
}
