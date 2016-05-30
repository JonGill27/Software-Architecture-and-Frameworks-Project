/*
    Jon Gillingsrud, s198618
    Christoffer Fredriksen, s198583
*/

package com.s198618s198583.java.service;

import com.s198618s198583.java.models.Contact;

import java.util.List;

public interface ContactService {

    List<Contact> getAllContacts();

    void addContact(Contact contact);

    void deleteContactById(int id);
}