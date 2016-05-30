/*
    Jon Gillingsrud, s198618
    Christoffer Fredriksen, s198583
*/

package com.s198618s198583.java.service;

import com.s198618s198583.java.dao.ContactDao;
import com.s198618s198583.java.models.Contact;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service("ContactService")
@Transactional
public class ContactServiceImpl implements ContactService {

    @Autowired
    private ContactDao dao;

    public List<Contact> getAllContacts() {
        return dao.getAllContacts();
    }

    public void addContact(Contact contact) {
        dao.addContact(contact);
    }

    public void deleteContactById(int id) {
        dao.deleteContactById(id);
    }
}