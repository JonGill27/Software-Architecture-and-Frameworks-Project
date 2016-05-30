/*
    Jon Gillingsrud, s198618
    Christoffer Fredriksen, s198583
*/

package com.s198618s198583.java.dao;

import com.s198618s198583.java.models.Contact;

import org.hibernate.Criteria;
import org.hibernate.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository("contactDao")
public class ContactDaoImpl extends AbstractContactDao<Integer, Contact> implements ContactDao {

    @SuppressWarnings("unchecked")
    public List<Contact> getAllContacts() {

        Criteria criteria = createEntityCriteria();
        return (List<Contact>) criteria.list();
    }

    public void addContact(Contact contact) {
        persist(contact);
    }

    public void deleteContactById(int id) {

        Query query = getSession().createSQLQuery("delete from Contact where ID = :id");
        query.setString(id, "id");
        query.executeUpdate();
    }
}